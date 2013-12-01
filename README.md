WAMTest
====

I uploaded the application in one commit because I am not very familiar with GitHub (normally use SVN at my job)

The algorithm implements 2 hashmaps, one with each start point as a key and the second one with each end of the route as a key. The hashmaps are filled using the information of the boarding tickets, 
The first hash map has the destiny of the boarding ticket as a key and the RouteVO information as a value.
The second hash map has the origin of the boarding ticket as a key and the RouteVO information as a value.

The algorithm goes through the 'destiny hashmap' in order to find the start point of the global route, once found it, it goes through the second hashmap ordering the whole route, looking for the key (origin) where the previous trip ends.

The implementation of the Algorithm has a O(n) complexity.

The RouteVO information saved is: Origin, destiny, trasnport and info. The
