"""
Amazon Fulfullment Builder is a new feature that enables Amazon warehouses to create new items 
to ship to customers out of smaller parts. As part of this project, Amazon wants to estimate the 
time it will take for a worker to create the item to be ready for a customer shipment. 

The Amazon Fulfillment Builder will provide an estimate about the time it will take for the item to 
be created based on the size of each of the parts. The worker can only combine two parts at a time.
The time required to put two parts together is equal to the sum of the parts sizes. THe size of the 
newly constructed part is also equal to the sum of the part's sizes. This process is repeated until 
all the parts have been merged together to form the final product.

Write an algorithm to output the minimum possible time to put the N parts together and build the final
product.

Input
The input to the function/method created takes one argument `parts`, a list of integers representing
the size of the parts.

Output
Return an interger representing the minimum time required to assemble all the parts

Note:
If number of parts == 1 then return 0

Example
Input:  
parts=[8,4,6,12]

Output:
58

Explanation
1.  [8, 10, 12]
2.  [18, 12]
3.  [30]
Ans: 10 + 18 + 30 = 58
"""
import heapq
def building_parts(parts):
    if len(parts) == 1:
        return 0
    time = 0
    heapq.heapify(parts)
    while len(parts) > 1:
        p1 = heapq.heappop(parts)
        p2 = heapq.heappop(parts)
        t = p1 + p2
        heapq.heappush(parts,t)
        time += t
    return time


def get_test_case():
    return [8, 4, 6, 12], 58

if __name__ == "__main__":
    parts, desired_res = get_test_case()
    res = building_parts(parts)
    print("\n\t Result: %s" % res)
    assert res == desired_res