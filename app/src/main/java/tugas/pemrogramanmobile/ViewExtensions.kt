package tugas.pemrogramanmobile

import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation

fun View.shake() {
    val animation = TranslateAnimation(0f, 20f, 0f, 0f)
    animation.duration = 100
    animation.repeatCount = 3
    animation.repeatMode = Animation.REVERSE
    this.startAnimation(animation)
}