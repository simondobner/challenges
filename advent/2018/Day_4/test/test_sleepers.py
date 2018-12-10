import os

from sleepers import Sleepers


def test_load_sleeptime_sorted():
    guards = Sleepers()
    guards.load_sleeptime(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    assert guards.sleep_log == ['[1518-11-01 00:00] Guard #10 begins shift\n',
                                '[1518-11-01 00:05] falls asleep\n',
                                '[1518-11-01 00:25] wakes up\n',
                                '[1518-11-01 00:30] falls asleep\n',
                                '[1518-11-01 00:55] wakes up\n',
                                '[1518-11-01 23:58] Guard #99 begins shift\n',
                                '[1518-11-02 00:40] falls asleep\n',
                                '[1518-11-02 00:50] wakes up\n',
                                '[1518-11-03 00:05] Guard #10 begins shift\n',
                                '[1518-11-03 00:24] falls asleep\n',
                                '[1518-11-03 00:29] wakes up\n',
                                '[1518-11-04 00:02] Guard #99 begins shift\n',
                                '[1518-11-04 00:36] falls asleep\n',
                                '[1518-11-04 00:46] wakes up\n',
                                '[1518-11-05 00:03] Guard #99 begins shift\n',
                                '[1518-11-05 00:45] falls asleep\n',
                                '[1518-11-05 00:55] wakes up']


def test_create_sleep_time_log():
    guards = Sleepers()
    guards.load_sleeptime(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    guards.create_sleep_time_log()
    assert guards.sleep_times['99'] == [40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
                                        36, 37, 38, 39, 40, 41, 42, 43, 44, 45,
                                        45, 46, 47, 48, 49, 50, 51, 52, 53, 54]


def test_extract_mintues():
    guards = Sleepers()
    minutes = guards.extract_minutes('[1518-11-04 00:36] falls asleep')
    assert minutes == 36


def test_extract_day():
    guards = Sleepers()
    day = guards.extract_day('[1518-11-04 00:36] falls asleep')
    assert day == 4


def test_extract_guard():
    guards = Sleepers()
    guards.change_the_guard('[1518-11-01 00:00] Guard #10 begins shift')
    assert guards.current_guard == '10'

    assert guards.sleep_times == {'10': []}


def test_get_most_sleepy_guard():
    guards = Sleepers()
    guards.load_sleeptime(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    guards.create_sleep_time_log()

    guards.get_most_sleepy_guard()
    assert guards.sleepiest_guard == '10'


def test_most_slept_minute():
    guards = Sleepers()
    guards.load_sleeptime(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    guards.create_sleep_time_log()
    guards.get_most_sleepy_guard()
    guards.get_most_slept_minute()


def test_get_guard_most_asleep_on_a_minute():
    guards = Sleepers()
    guards.load_sleeptime(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    guards.create_sleep_time_log()
    guards.get_most_sleepy_guard()
    guards.get_guard_most_asleep_on_a_minute()

    assert guards.sleepiest_guard_minute_combo == 4455
