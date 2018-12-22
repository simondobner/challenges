import os


class PolymerReactor:
    def __init__(self, input_file: str = None):

        self.polymerised_string: str = None
        if input_file is None:
            input_file = '/test/resources/test_input.txt'

        with open(str(os.path.dirname(__file__)) + input_file, 'r') as infile:
            for line in infile:
                self.polymer = line

    @staticmethod
    def primary_reactor(in_polymer):

        before_string: str = None
        after_string = in_polymer

        while before_string != after_string:
            before_string = after_string
            for p in range(0, 26):
                after_string = after_string.replace(chr(ord('a') + p) + chr(ord('A') + p), '')
                after_string = after_string.replace(chr(ord('A') + p) + chr(ord('a') + p), '')

        return after_string

    def bad_unit_stripper(self):

        temp_poly = self.polymer
        temp_poly_dict = {}
        for n in range(0, 25):
            temp_poly_dict[chr(ord("a") + n)] = len(self.primary_reactor(
                temp_poly.replace(chr(ord("a") + n), '').replace(chr(ord('A') + n), '')))

        return temp_poly_dict

    def get_shortest_polymer(self):
        length_dict = self.bad_unit_stripper()
        return length_dict[min(length_dict, key=length_dict.get)]


if __name__ == '__main__':
    polymer = PolymerReactor('/input.txt')
    print(f'Units remaining is: {len(polymer.primary_reactor(polymer.polymer))}')
    print(f'Shortest clean polymer is {polymer.get_shortest_polymer()}')