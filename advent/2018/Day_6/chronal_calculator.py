import os
import numpy


class ChronalCalculator:
    def __init__(self, input_file: str = None):
        a = numpy.array([[0, 1, 2], [3, 4, 5], [6, 7, 8]])

        self.chronal_layout = []
        self.coordinates = []
        if input_file is None:
            input_file = '/test/resources/test_input.txt'

        with open(str(os.path.dirname(__file__)) + input_file, 'r') as infile:
            for line in infile:
                self.coordinates.append((line.replace(' ', '').rstrip().split(','))
                                        )

    # def plot_coordinates(self):
    #     for coords in self.coordinates:
    #         print(coords.replace(' ', '').rstrip().split(','))

    def setup_coordinate_matrix(self):
        """
        create an array on Nones the size of the left, right,top, bottom coordinates
        :return:
        """

        print(self.coordinates)
        min_x = sorted(set([l[0] for l in self.coordinates]), reverse=False)[0]
        max_x = sorted(set([l[0] for l in self.coordinates]), reverse=True)[0]
        min_y = sorted(set([l[1] for l in self.coordinates]), reverse=False)[0]
        max_y = sorted(set([l[1] for l in self.coordinates]), reverse=True)[0]

        print(f'coords are {min_x} {max_x} {min_y} {max_y}')

    def get_poosible_coords(self):
        """
        To be of any interest, a coord must have a neighbour above, below, left and right
        :return:
        """
        for coords in self.coordinates:
            # print(coords.replace(' ', '').rstrip().split(','))
            x, y = (coords.replace(' ', '').rstrip().split(','))

            print(f'this y is {y}')
            # is there a higher (y) coord
            # is there a lower (y) coord
            print(f'this y is {x}')
            # is there a lefter (x) coord
            # is there a righter (x) coord

    # def create_grid_list(self):
    #     # setup the grid
    #     x = -8, y = 7
    #     grid = [][]

    # grid[x][y] = 'A'

    def is_point_on_boundary(self, point, boundary):

        print(f'point is{point}')
        print(f'boundary is{boundary}')
        print(f'coords are {self.coordinates}')
        if ((point >= sorted(set([l[0] for l in self.coordinates]), reverse=False)[0] and boundary == 'right')
                or (point <= sorted(set([l[0] for l in self.coordinates]), reverse=True)[0] and boundary == 'left')
                or (point >= sorted(set([l[1] for l in self.coordinates]), reverse=True)[0] and boundary == 'top')
                or (point <= sorted(set([l[1] for l in self.coordinates]), reverse=True)[0] and boundary == 'bottom')):
            print(f'point{point} is on the boundary')
            return True

    def get_closest_point(self, cell):
        """
        Find the closest point, return None if it's shared
        :param cell:
        :return:
        """


"""
For each cell ( not on a boundary):
    find the closet point
    ignore equals
    add to cumulative total for the closet point

    print point with biggest number
    Done.    
"""
