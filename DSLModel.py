import dslUtils
import sys
import re


class Analysis:

    def __init__(self, name):
        self._name = name
        self._datasets = []
        self._groups = []
        self._gene_lists = []
        self._diff_expr_lists = []
        self._connection_lists = []

    def add_dataset(self, dataset):
        self._datasets.append(dataset)

    def add_group(self, group):
        self._groups.append(group)

    def add_gene_list(self, gene_list):
        self._gene_lists.append(gene_list)

    def add_connection_list(self, connection_list):
        self._connection_lists.append(connection_list)

    def add_diff_expr_list(self, diff_expr_list):
        self._diff_expr_lists.append(diff_expr_list)

    def find_dataset(self, name):
        for d in self._datasets:
            if d.get_name() == name:
                return d
        return None

    def find_gene_list(self, name):
        for gl in self._gene_lists:
            if gl.get_name() == name:
                return gl
        return None

    def find_group(self, name):
        for g in self._groups:
            if g.get_name() == name:
                return g
        return None

    def resolve(self):
        for g in self._groups:
            d = self.find_dataset(g.get_dataset())
            try:
                repository = d.get_repository()
            except AttributeError:
                sys.exit("Please ensure you dataset name/groups are spelt correctly")
            series = d.get_identifier()
            stack = g.get_filter()
            group_samples = dslUtils.evaluate_group_criteria(repository, series, stack)
            g.set_data(list(group_samples[0]))

    def run(self):
        for de in self._diff_expr_lists:
            group_names = de.get_groups()
            #try:
            ds = self.find_dataset(self.find_group(group_names[0]).get_dataset())
            #except AttributeError:
            #    sys.exit("Please ensure your differential group names do not match!")
            series_name = ds.get_identifier()
            samples = [self.find_group(gn).get_data() for gn in group_names]
            #fdr = self.get_filter()
            dslUtils.calc_differentials(series_name, de.get_name(), samples)
            #dslUtils.plotting(series_name)
        for gl in self._gene_lists:
            de = gl.get_differential_expression()
            f = gl.get_filter()
            up, down = dslUtils.create_gene_lists(de, f)
            gl.set_up_probes(up)
            gl.set_down_probes(down)
        for cl in self._connection_lists:
            gl = self.find_gene_list(cl.get_gene_list())
            dslUtils.create_connection_lists(cl, gl)
            dslUtils.results_dir(series_name)



class Dataset:

    def __init__(self, name):
        self._name = name
        self._repository = ''
        self._identifier = ''
        self._data = []

    def set_repository(self, repository):
        self._repository = repository

    def set_identifier(self, identifier):
        self._identifier = identifier


    def add_data(self, data):
        self._data.append(data)

    def set_data(self, data):
        self._data = data

    def get_name(self):
        return self._name

    def get_repository(self):
        return self._repository

    def get_identifier(self):
        return self._identifier


class ExpressionGroup:

    def __init__(self, name, dataset):
        self._name = name
        self._dataset = dataset
        self._filter = []
        self._data = []

    def set_data(self, data):
        self._data = data
        
    def get_data(self):
        return self._data
        
    def add_data(self, data):
        self._data.append(data)

    def add_filter_term(self, term):
        self._filter.append(term)

    def get_name(self):
        return self._name

    def get_dataset(self):
        try:
            return self._dataset
        except UnboundLocalError:
            sys.exit("missing or misspelt terms! Please check script")
        except AttributeError:
            sys.exit("Missing or misspelt terms!")

    def get_filter(self):
        return self._filter


class GeneList:

    def __init__(self, name, differential_expression):
        self._name = name
        self._differential_expression = differential_expression
        self._filter = []
        self._up_probes = []
        self._down_probes = []

    def add_up_probe(self, probe_id):
        self._up_probes.append(probe_id)

    def set_up_probes(self, up_probes):
        self._up_probes = up_probes

    def get_up_probes(self):
        return self._up_probes

    def add_down_probe(self, probe_id):
        self._down_probes.append(probe_id)

    def set_down_probes(self, down_probes):
        self._down_probes = down_probes

    def get_down_probes(self):
        return self._down_probes

    def add_filter_term(self, term):
        self._filter.append(term)

    def get_filter(self):
        return self._filter

    def get_differential_expression(self):
        return self._differential_expression

    def get_name(self):
        return self._name


class ConnectionList:

    def __init__(self, name, gene_list, direction):
        self._name = name
        self._gene_list = gene_list
        self._direction = direction
        self._file = None
        self._results = []

    def set_file(self, file):
        self._file = file

    def set_results(self, results):
        self._results = results

    def get_name(self):
        return self._name

    def get_gene_list(self):
        return self._gene_list

    def get_direction(self):
        return self._direction


class ExpressionData:

    def __init__(self, name, filename):
        self._name = name
        self._filename = filename


class DifferentialExpressionList:

    def __init__(self, name):
        self._name = name
        self._group_ids = []

    def get_name(self):
        return self._name
    
    def add_group(self, group):
        self._group_ids.append(group)

    def get_groups(self):
        return self._group_ids

    def add_filter_term(self, term):
        self._filter.append(term)

class CriteriaTree:

    def __init__(self, left, operator, right):
        self._left = left
        self._operator = operator
        self._right = right

