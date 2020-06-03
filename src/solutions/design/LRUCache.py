class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None
            
class LRUCache:
    
    def __init__(self, capacity: int):
        self.capacity = capacity
        
        # init Doubly linked list
        self.head = Node(sys.maxsize, None)
        self.tail = Node(-sys.maxsize-1, None)
        self.head.next = self.tail
        self.tail.prev = self.head
        
        # init hashmap
        self.hmap = {}

    def get(self, key: int) -> int:
        if key not in self.hmap:
            # print('\nget %d not found and size=%d' % (key, len(self.hmap)))
            # self.print_node()
            return -1
        else:
            # print('\nget %d: %d and size=%d' % (key, self.hmap[key].val, len(self.hmap)))
            found_node = self.hmap[key]
            self.remove(found_node)
            newly_added_node = self.add(key, found_node.val)
            # self.print_node()
            return newly_added_node.val
        

    def put(self, key: int, value: int) -> None:
        # print('\nput %d: %d and size=%d' % (key, value, len(self.hmap)))
        if key not in self.hmap:
            if len(self.hmap) == self.capacity:
                # remove the the one before tail (the least used one)
                self.remove(self.tail.prev)

            # insert it right after head
            self.add(key, value)
        else:
            # self.hmap[key].val = value
            found_node = self.hmap[key]
            self.remove(found_node)
            newly_added_node = self.add(key, value)
        #self.print_node()
    
    def add(self, key, value):
        cur_head = self.head.next
        new_cur_node = Node(key, value)
        cur_head.prev = new_cur_node
        new_cur_node.next = cur_head
        new_cur_node.prev= self.head
        self.head.next = new_cur_node
        self.hmap[key] = new_cur_node
        # print(' add %d: %d and size=%d' % (new_cur_node.key, new_cur_node.val, len(self.hmap)))
        return new_cur_node
    
    def remove(self, node):
        # print(' removing %d: %d' % (node.key, node.val))
        left = node.prev
        right = node.next
        left.next = right
        right.prev = left
        if node.key in self.hmap:
            del self.hmap[node.key]
"""
    def print_node(self):
        node = self.head.next
        tmp_str = ""
        while node.key != -sys.maxsize-1:
            tmp_str += ("(" + str(node.key) + "," + str(node.val) + ") -> ")
            node = node.next
        tmp_str += "x"
        print(tmp_str)
"""
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
