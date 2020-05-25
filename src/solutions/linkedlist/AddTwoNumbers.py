"""
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order 
and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
"""

"""
Time Complexity: O(n) where n is the max(l1,l2)
Space Complexity: O(1) since we're doing in place replacement
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def find_max_len(self, list1, list2):
        a = 0
        l1 = list1
        l2 = list2
        while l1 != None:
            a += 1
            l1 = l1.next
        b = 0
        while l2 != None:
            b += 1
            l2 = l2.next
            
        return (a, list1, list2) if a >= b else (b, list2, list1)
    
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carryover = 0
        max_len, ll1, ll2 = self.find_max_len(l1, l2)
        ptr = ll1
        
        while ll1 != None:
            added = ll1.val + carryover
            if ll2 != None:
                added += ll2.val
                ll2 = ll2.next
            ll1.val = added % 10
            carryover = added // 10
            ll1.next = ListNode() if (ll1.next == None and carryover > 0) else ll1.next
            ll1 = ll1.next
            
        return ptr
                
                
    
    
