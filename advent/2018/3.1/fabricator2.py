import os


class Fabricator:
    def __init__(self, fabric_size=None):
        if fabric_size is None:
            fabric_size = 1000

        self.fabric = [[0 for x in range(fabric_size)] for y in range(fabric_size)]
        self.claims = [[0 for x in range(fabric_size)] for y in range(fabric_size)]
        self.claim_list = []
        self.bad_claims = []

    def get_claim_number(self, x, y):
        return self.claims[x][y]

    def add_claim(self, claim):
        claim_number = claim.split()[0].replace('#', '')
        across, down = claim.split()[2].replace(':', '').split(',')
        wide, deep = claim.split()[3].split('x')
        self.claim_list.append(claim_number)

        down, wide, across, deep = int(down), int(wide), int(across), int(deep)

        for down_counter in range(down, down + deep):
            for across_counter in range(across, across + wide):
                self.fabric[down_counter][across_counter] += 1
                if self.claims[down_counter][across_counter] != 0:
                    self.bad_claims.append(claim_number)
                    self.bad_claims.append(self.claims[down_counter][across_counter])
                else:
                    self.claims[down_counter][across_counter] = claim_number

    def get_overlap_count(self):
        count = 0
        for row in self.fabric:
            count += len([1 for i in row if i > 1])

        return count

    def get_good_claim(self):
        return set(set(self.claim_list).difference(self.bad_claims))


if __name__ == '__main__':
    fabric = Fabricator()
    with open(str(os.path.dirname(__file__)) + '/input.txt', 'r') as infile:
        for line in infile:
            fabric.add_claim(line)
    print(f'Overlap Counts is: {fabric.get_overlap_count()}')
    print(f'The good claim is: {fabric.get_good_claim()}')
