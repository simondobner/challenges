from chronal_calculator import ChronalCalculator


def test_when_instantiated_coordinates_are_loaded():
    chronal = ChronalCalculator()
    print(chronal.coordinates)
    assert chronal.coordinates == ['1, 1\n', '1, 6\n', '8, 3\n', '3, 4\n', '5, 5\n', '8, 9']


def test_plot_coordinates():
    chronal = ChronalCalculator()
    chronal.plot_coordinates()
    assert chronal.chronal_layout == []


def test_when_a_point_is_on_a_boundary_returns_true():
    chronal = ChronalCalculator()
    chronal.is_point_on_a_boundary(8, 'right')


def test_when_sent_set_of_coords_min_amd_max_values_correctly_calculated():
    chronal = ChronalCalculator()
    chronal.setup_coordinate_matrix()