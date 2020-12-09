Android Architecture Components - even more - Advanced Navigation Sample
==============================================

This project is based on [Android's NavigationAdvancedSample of the architecture-components-samples](https://github.com/android/architecture-components-samples/tree/main/NavigationAdvancedSample).
It is meant as a POC for a more complex navigation stack we'll be using in our (private) main project.

We're also adding some additional project complexity with which the bottom navigation should co-operate with.

### Additional Features
1) The navigation is 'even more complex' compared to the original:
    - A shared nav_graph at the end of each bottom-nav feature's backstack (included in the main nav_graphs)
    - A variable set of BottomNavItems (we want to enable our user to modify the order of these in the end, so cannot use the usual `menu.xml` for our BottomNavItems).
    - Minor tweaks to `NavigationExtensions` for a different back experience
2) The project is split in several modules (these should eventually be dynamic feature modules)
TODO:
3) Dagger implementation
