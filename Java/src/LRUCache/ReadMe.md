### LRU: Least Recently Used

This algorithm uses LinkedList to implement LRU cache discard problem.

    check if the new node is in the list  
	if it is in the list  
		move this node to list head  
	if it is not in the list  
        	if the list is full  
            		delete the list tail node  
            		add the new node to list head  
        	if the list is not full  
            		add the new node to list head  
