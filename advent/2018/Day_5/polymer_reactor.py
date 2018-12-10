import os


class PolymerReactor:
    def __init__(self, input_file: str = None):

        if input_file is None:
            input_file = '/test/resources/test_input.txt'

        with open(str(os.path.dirname(__file__)) + input_file, 'r') as infile:
            for line in infile:
                self.polymer = list(line)

    def reactor(self):

        poly_elements_reacted = False
        for poly_position in range(1, len(self.polymer) - 1):
            # print(f'c1 :{self.polymer[poly_position]} c2: {self.polymer[poly_position - 1].upper()}')

            if self.polymer[poly_position] == self.polymer[poly_position - 1].upper() \
                    or self.polymer[poly_position].upper() == self.polymer[poly_position - 1]:
                # print(self.polymer[poly_position], self.polymer[poly_position - 1])
                del self.polymer[poly_position - 1: poly_position + 1]
                poly_elements_reacted = True
                break
        return poly_elements_reacted

    def process_polymer(self):
        polymer_processing_incomplete = True

        while polymer_processing_incomplete:
            polymer_processing_incomplete = self.reactor()


if __name__ == '__main__':
    polymer = PolymerReactor('/input.txt')
    polymer.process_polymer()
    print(''.join(polymer.polymer))
