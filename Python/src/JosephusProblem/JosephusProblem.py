class Node(object):
    def __init__(self, value):
        self.value = value
        self.next = None

def creatLinkList(nodeNumber):
    head = Node(0)
    preNode = head
    for i in range(1, nodeNumber):
        curNode = Node(i)
        preNode.next = curNode
        preNode = curNode
    preNode.next = head
    return head

nodeNumber = int(input("The total node number: "))
countNumber = int(input("The counting Number: "))

if countNumber == 1:
    print(nodeNumber-1)
else:
    head = creatLinkList(nodeNumber)
    preNode = None
    curNode = head
    while curNode.next != curNode:
        for i in range(1, countNumber):
            preNode = curNode
            curNode = curNode.next
        preNode.next = curNode.next
        curNode.next = None
        curNode = preNode.next
    print(curNode.value)
