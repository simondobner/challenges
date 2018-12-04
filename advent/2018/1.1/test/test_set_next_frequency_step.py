import os

from advent1_2 import FrequencyMonitor


def test_set_next_frequency_step_add_one():
    """
    +1, +1, +1 results in  3
    +1, +1, -2 results in  0
    -1, -2, -3 results in -6

    :return:
    """

    freq_mon = FrequencyMonitor(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    freq_mon.frequency = 0
    freq_mon.set_next_frequency_step(1)
    freq_mon.set_next_frequency_step(1)
    freq_mon.set_next_frequency_step(1)
    assert freq_mon.frequency == 3

    freq_mon.frequency = 0
    freq_mon.set_next_frequency_step(1)
    freq_mon.set_next_frequency_step(1)
    freq_mon.set_next_frequency_step(-2)
    assert freq_mon.frequency == 0

    freq_mon.frequency = 0
    freq_mon.set_next_frequency_step(-1)
    freq_mon.set_next_frequency_step(-2)
    freq_mon.set_next_frequency_step(-3)
    assert freq_mon.frequency == -6


def test_get_frequency_changes():
    line_list = []

    freq_mon = FrequencyMonitor(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    for line in freq_mon.get_frequency_changes():
        line_list.append(line)
    assert len(line_list) == 10


def test_frequency_processor():
    print(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    freq_mon = FrequencyMonitor(str(os.path.dirname(__file__)) + '/resources/test_input.txt')

    # while freq_mon.frequency != 14:
    while freq_mon.frequency_found is False:
        freq_mon.frequency_processor()

    assert freq_mon.duplicate_frequency == 14
    assert len(freq_mon.seen_frequencies) == 13
