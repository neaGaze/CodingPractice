"""
Amazon Fresh is running a promotion in which customers receive prizes for purchasing a secret
combination of fruits. The combination will change each day, and the team running the promotion 
wants to use a code list to make it easy to change the combination. The code list contains groups
of fruits. Both the order of the groups within the code list and the order of the fruits within 
the groups matter. However, between the groups of fruits, any number, and type of fruit is allowable.
The term "anything" is used to allow for any type of fruit to appear in that location within the 
group. Consider the following secret code list: 

[[apple, apple], [banana, anything, banana]]
Based on the above secret code list, a customer who made either of the following purchases would
win the prize:

orange, apple, apple, banana, orange, banana
apple, apple, orange, orange, banana, apple, banana, banana

Write an algorithm to output 1 if the customer is a winner else output 0.
//
------- Input --------------
The input to the function/method consists of two arguments:
codeList, a list of lists of strings representing the order and grouping of specific fruits that 
must be purchased in order to win the prize for the day. shoppingCart, a list of strings representing 
the order in which a customer purchases fruit.
	
--------- Output ------------------
Return an integer 1 if the customer is a winner else return 0.
Note
'anything' in the codeList represents that any fruit can be ordered in place of 'anything' in the
group. 'anything' has to be something, it cannot be "nothing." 'anything' must represent one and 
only one fruit. If secret code list is empty then it is assumed that the customer is a winner.
	
Example 1
-----------------------------
Input 
codeList = [[apple, apple], [banana, anything, banana]] 
shoppingCart = [orange, apple, apple, banana, orange, banana]
Output: 1
	
Example 2
-----------------------------
Input 
codeList = [[apple, apple], [banana, anything, banana]] 
shoppingCart = [banana, orange, banana, apple, apple]
Output: 0

//  Example 3
-----------------------------
Input 
codeList = [[apple, apple], [banana, anything, banana]] 
shoppingCart = [apple, banana, apple, banana, orange, banana]
Output: 0
	
//  Example 4
-----------------------------
Input 
codeList = [[apple, apple], [apple, apple, banana]] 
shoppingCart = [apple, apple, apple, banana]
Output: 0


//  Example 5
-----------------------------
Input 
codeList = [[apple, apple], [apple, apple, banana]] 
shoppingCart = [mango, apple, apple, apple, apple, apple, apple, apple, banana, apple, apple, banana]
Output: 1
"""
def fresh_promotion(codelist, shopping_cart):
    codelist
    i, j = 0, 0
    while len(codelist) > 0 and i < len(shopping_cart):
        if codelist[0][0] == shopping_cart[i] or codelist[0][0] == "anything":
            m = 0
            j = i
            while m < len(codelist[0]) and (codelist[0][m] == shopping_cart[j] or codelist[0][m] == "anything"):
                j += 1
                m += 1

            if m == len(codelist[0]):
                codelist.pop(0)
                i = j
            else:
                i += 1
        else:
            i += 1
    
    return 1 if len(codelist) == 0 else 0


def get_test_case():
    return [["apple", "apple"], ["apple", "apple", "banana"]], ["mango", "apple", "apple", "apple", "apple", "apple", "apple", "apple", "banana", "apple", "apple", "banana"], 1
    # return [["apple", "apple"], ["banana", "anything", "banana"]], ["orange", "apple", "apple", "banana", "orange", "banana"], 1
    # return [["apple", "apple"], ["banana", "anything", "banana"]], ["banana", "orange", "banana", "apple", "apple"], 0
    # return [["apple", "apple"], ["banana", "anything", "banana"]], ["apple", "banana", "apple", "banana", "orange", "banana"], 0
    # return [["apple", "apple"], ["apple", "apple", "banana"]], ["apple", "apple", "apple", "banana"], 0


if __name__ == "__main__":
    codelist, shopping_cart, desired_res = get_test_case()
    res = fresh_promotion(codelist, shopping_cart)
    print("\n\t Result: %s" % res)
    assert res == desired_res

