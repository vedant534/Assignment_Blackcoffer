package com.example.netclanexplorerscreens.exploreScreen

import com.example.netclanexplorerscreens.R

fun getItems():List<IconItem>{
    return  listOf(
        IconItem(
            id = 0,
            iconRes = R.drawable.myprofile,
            label = "My Profile"
        ),
        IconItem(
            id = 1,
            iconRes = R.drawable.people_svgrepo_com,
            label = "My Network"
        ),
        IconItem(
            id = 22,
            iconRes = R.drawable.business_suitcase_svgrepo_com,
            label = "Switch to Business"
        ),
        IconItem(
            id = 2,
            iconRes = R.drawable.personal_elevator_signal_svgrepo_com,
            label = "Switch to Personal"
        ),
        IconItem(
            id = 3,
            iconRes = R.drawable.shop_svgrepo_com,
            label = "Switch to Merchant"
        ),
        IconItem(
            id = 12,
            iconRes = R.drawable.shopping,
            label = "Buy-Sell-Rent"
        ),
        IconItem(
            id = 4,
            iconRes = R.drawable.bizcard,
            label = "Business Cards"
        ),
        IconItem(
            id = 5,
            iconRes = R.drawable.hashtag_svgrepo_com,
            label = "Netclan Groups"
        ),
        IconItem(
            id = 6,
            iconRes = R.drawable.notes_svg,
            label = "Notes",
        ),
        IconItem(
            id = 7,
            iconRes = R.drawable.location_pin_svgrepo_com,
            label = "Live location"
        )
    )

}