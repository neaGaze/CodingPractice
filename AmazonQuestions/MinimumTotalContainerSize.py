"""
Input 1
P = [10, 2, 20, 5, 15, 10, 1]
d = 3
Output:
31

Input 2
P = [5, 4, 2, 4, 3, 4, 5, 4]
d = 4
Output:
16


Input 3
P = [22, 12, 1, 14, 17]
d = 2
Output:
39

0 =>  10
1 =>  12 
2 =>  32
3 =>  10
4 =>  10
5 =>  10
6 =>  10
7 => 

[, 5, 15, 15, 10, 1]
"""

def get_test_case():
    return [10, 2, 20, 5, 15, 10, 1], 3

def min_total_container_size(P, d):
    pass

if __name__ == "__main__":
    size, cmds, desired_res = get_test_case()
    res = min_total_container_size(size, cmds)
    assert res == desired_res
    print(res)

