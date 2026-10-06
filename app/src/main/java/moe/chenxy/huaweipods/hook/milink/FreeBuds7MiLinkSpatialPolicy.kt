package moe.chenxy.huaweipods.hook.milink

import moe.chenxy.huaweipods.pods.FreeClip2SpatialAudioMode

/** MiLink 17.2.6: native card 1=fixed, 2=head tracking; Huawei wire values are reversed. */
internal object FreeBuds7MiLinkSpatialPolicy {
    fun fromDisplay(value: Int): FreeClip2SpatialAudioMode? = when (value) {
        0 -> FreeClip2SpatialAudioMode.OFF
        1 -> FreeClip2SpatialAudioMode.FIXED
        2 -> FreeClip2SpatialAudioMode.HEAD_TRACKING
        else -> null
    }

    fun display(mode: FreeClip2SpatialAudioMode?): Int = when (mode) {
        FreeClip2SpatialAudioMode.OFF -> 0
        FreeClip2SpatialAudioMode.FIXED -> 1
        FreeClip2SpatialAudioMode.HEAD_TRACKING -> 2
        null -> -1
    }

    fun runtime(mode: FreeClip2SpatialAudioMode?): Int = when (mode) {
        FreeClip2SpatialAudioMode.HEAD_TRACKING -> 11
        else -> display(mode)
    }
}
