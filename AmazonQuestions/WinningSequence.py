"""
Example 1:
Input: n=4, lowerBound=10, upperBound=12
Output: [11, 12, 11, 10]

Explanation: 
    [11, 12, 11, 10] *
    [10, 11, 12, 11]
    [10, 11, 12, 10]
    [10, 12, 11, 10]

Example 2:
Input: n=6, lowerbound=1, outerBound=3
Output: null
"""
# cur_max = None

class Work():
    def __init__(self):
        self.cur_max = None

    def calc_max(self, elements, upperBound):
        print("Checking elems: %s vs cur_max: %s" % (elements, self.cur_max))
        ind = elements.index(upperBound)
        if ind <= 0 or ind == len(elements)-1:
            return self.cur_max
        if self.cur_max == None:
            self.cur_max = [x for x in elements]
        i = 0
        while i < len(elements): # assuming elements and cur_max have the same length
            if elements[i] > self.cur_max[i]:
                self.cur_max = [x for x in elements]
                return self.cur_max
            elif self.cur_max[i] > elements[i]:
                return self.cur_max
            i += 1
        print("\t cur_max: %s" % self.cur_max)
        return self.cur_max

    def recurse(self, x, n, elements, ascend, lowerBound, upperBound):
        if len(elements) > n:
            return

        if len(elements) == n:
            self.cur_max = self.calc_max(elements, upperBound)
            return

        if x < lowerBound or x > upperBound:
            return 

        start, end = (x + 1, upperBound + 1) if ascend else (x - 1, lowerBound - 1)
        # print("\t elems: %s, start: %d, end: %d" % (elements, start, end))

        for i in range(start, end, 1 if ascend else -1):
            self.recurse(i, n, elements + [i], (ascend if ascend == False else i < upperBound), lowerBound, upperBound)

    # [10, 11, 12, 11]
    # [10, 11, 12, 10]
    # [10, 12, 11, 10]
    # [10, 12, 10]
    # [11]

    def winning_sequence(self, n, lowerBound, upperBound):
        # cur_max = None
        for i in range(lowerBound, upperBound):
            self.recurse(i, n, [i], True, lowerBound, upperBound)
        return self.cur_max

def get_test_case():
    # return 4, 10, 12, [11, 12, 11, 10]
    # return 6, 1, 3, None
    return 6, 10, 14, [13, 14, 13, 12, 11, 10]

if __name__ == "__main__":
    n, lowerbound, upperbound, desired_res = get_test_case()
    # cur_max = None
    work = Work()
    res = work.winning_sequence(n, lowerbound, upperbound)
    print("\n\t Result: %s" % res)
    assert res == desired_res

