# CarouselRecyclerView
![Alt text](https://github.com/grishko188/CarouselRecyclerView/blob/master/screenshot/Screenshot.png?raw=true "Screen shot")
<br/>
<br/>
Originally based on [WearableListView](https://developer.android.com/reference/android/support/wearable/view/WearableListView.html)
<br/>An alternative version of WearableListView adapted for handled devices.
<br/> **Support vertical scrollbar, using with SwipeRefreshLayout, and customizing child view height** 
<br/>(WearableListView's child height cannot be bigger than 1/3 of parent height) 
<br/>It displays a vertically scrollable list of items
,and automatically snaps to the nearest item when the user stops scrolling. 
<br/>CarouselRecyclerView provides the ability to select center child item. 
<br/><br/> **Usage:**
<br/><li> [WearableListView usage](https://developer.android.com/training/wearables/ui/lists.html) (CarouselRecyclerView has the same usage as original component)</li>
<br/><li> [Look at the sample project](https://github.com/grishko188/CarouselRecyclerView/tree/master/app)</li>
<br/><br/><br/> **Customizing child view height use  one of the given methods :**
<br/> _(by default CarouselRecyclerView has child weight 1/3)_
<br><li>`public void setChildViewHeight(int childViewHeight)`</li>
<br><li>`public void setChildViewWeight(int mChildViewWeight)`</li>
<br><li>`public void setChildViewProportionsAccordingToWidth(double childViewProportionsAccordingToWidth)`</li>