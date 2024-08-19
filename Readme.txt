

    insertItem O(n) = n^2 = because in a for loop that could loop n times and inside
    that for loop my method getNode has a for loop that could loop n times
    so n * n = n^2
    deleteItem O(n) = n = because it calls getNode which has a for loop that could loop n times
    and because it calls my seachItem method which has a for loop that could loop n times

    MergeList:


Function mergeList
    pass in: SortedLinkedList object list

    initialize copy = new SortedLinkedList;

    for( i .... < list.length) {          //  n times
        insert items from list into copy by insert() // n^2
    }

    initialize merge = new SortedLinkedList;

    for( i .... < length of current list object) {  //n
        for( i .... < list.length) { //n
            if ( node in current list is equal to node in passed in list copy)
            delete item from copy by delete() //n
        }
    }

    for( i .... < length of current list object) { //n

        insert item into merge list by insert(); // n^2
    }

    for( i .... < length of copylist object) { // n
        insert item into merge list by insert(); // n^2
    }

    return merge list;
End function

    So with considertaion to other function called with in my fuction like insert and delete and other functions called by those functions, like getNode and searchItem, the overall complexity of my merge function is
    <= (n*n^2) + (n*n*n) + (n*n^2) + (n*n^2)
    <=  4n^3
     so mergeList O(n) = n^3


    findIntersection:

Function findIntersection
    pass in: SortedLinkedList object list

    for( i ..... < current list object length) { //n
        for( i ...... < passed in list obejct length) { //n

    print(Node( at j)'s value ); //n because i call my getNode function which has the
                                     the possiblity of looping n times before returning
                                     the specified node at j
        }
    }

End Function

    So with considertaion to other function called with in my fuction like getNode, the overall complexity of my merge function is is

    <= (n * n * n)
    <= n^3
    so findIntersection O(n) = n^3
