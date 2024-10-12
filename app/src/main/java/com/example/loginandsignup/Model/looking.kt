package com.example.loginandsignup.Model

import androidx.annotation.DrawableRes
import com.example.loginandsignup.R

data class looking(@DrawableRes val Image:Int,val type:String)
var Looklist= mutableListOf<looking>(looking(R.drawable.cupid_arrow,"Long-term partner"),
    looking(R.drawable.emoji,"Long-term,open to short"),
    looking(R.drawable.wine_glasses,"Short-term,Open to Long"),
    looking(R.drawable.confetti,"Short-term fun"),
    looking(R.drawable.clapping,"New friends"),
    looking(R.drawable.thinking,"Still figuring it out")
)
