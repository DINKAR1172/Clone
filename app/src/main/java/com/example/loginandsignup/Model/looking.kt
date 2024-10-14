package com.example.loginandsignup.Model

import androidx.annotation.DrawableRes
import com.example.loginandsignup.R

data class looking(val id:Int,@DrawableRes val Image:Int,val type:String)
var Looklist= mutableListOf<looking>(looking(0,R.drawable.cupid_arrow,"Long-term partner"),
    looking(1,R.drawable.emoji,"Long-term,open to short"),
    looking(2,R.drawable.wine_glasses,"Short-term,Open to Long"),
    looking(3,R.drawable.confetti,"Short-term fun"),
    looking(4,R.drawable.clapping,"New friends"),
    looking(5,R.drawable.thinking,"Still figuring it out")
)
