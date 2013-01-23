TestGoogleMaps
==============

Test new Google Maps API v2

I'm trying to integrate ActionBarSherlock with the new Google Maps API v2 but I'm having a problem.

I have a layout with 2 fragments: one for a list layout and another with a SupportMapFragment.

When I click on a list item first go well but when I click on a list item second time, it throws an error: " Duplicate id 0x7f040038, tag null, or parent id 0x0 with another fragment for com.google.android.gms.maps.SupportMapFragment"

I tried several solutions and none of them have been able to fix it. Is there something I'm doing wrong? 

Please help me!!

I modified ActionBarSherlock to include SherlockMapFragment implemented to support the new SupportMap (as shown here: https://gist.github.com/4392030).

This is an image of my test project:
http://i.stack.imgur.com/ICtbz.png
