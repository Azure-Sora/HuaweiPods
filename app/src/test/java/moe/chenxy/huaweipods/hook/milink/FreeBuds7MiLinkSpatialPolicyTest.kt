package moe.chenxy.huaweipods.hook.milink

import moe.chenxy.huaweipods.pods.FreeClip2SpatialAudioMode
import org.junit.Assert.*
import org.junit.Test

class FreeBuds7MiLinkSpatialPolicyTest {
    @Test fun nativeButtonsDoNotReuseReversedHuaweiWireValues() {
        assertEquals(FreeClip2SpatialAudioMode.FIXED, FreeBuds7MiLinkSpatialPolicy.fromDisplay(1))
        assertEquals(FreeClip2SpatialAudioMode.HEAD_TRACKING, FreeBuds7MiLinkSpatialPolicy.fromDisplay(2))
        assertEquals(1, FreeBuds7MiLinkSpatialPolicy.display(FreeClip2SpatialAudioMode.FIXED))
        assertEquals(2, FreeBuds7MiLinkSpatialPolicy.display(FreeClip2SpatialAudioMode.HEAD_TRACKING))
        assertEquals(11, FreeBuds7MiLinkSpatialPolicy.runtime(FreeClip2SpatialAudioMode.HEAD_TRACKING))
        assertEquals(0, FreeBuds7MiLinkSpatialPolicy.runtime(FreeClip2SpatialAudioMode.OFF))
    }

    @Test fun unknownOrInvalidStateDoesNotBecomeOff() {
        assertEquals(-1, FreeBuds7MiLinkSpatialPolicy.display(null))
        assertEquals(-1, FreeBuds7MiLinkSpatialPolicy.runtime(null))
        assertNull(FreeBuds7MiLinkSpatialPolicy.fromDisplay(-1))
        assertNull(FreeBuds7MiLinkSpatialPolicy.fromDisplay(11))
    }

    @Test fun nativePercentageSiblingSuppressesDuplicateVolumeText() {
        assertTrue(FreeClip2MiLinkUiPolicy.hasNativeVolumePercentage(listOf("| 23%")))
        assertTrue(FreeClip2MiLinkUiPolicy.hasNativeVolumePercentage(listOf("23%")))
        assertFalse(FreeClip2MiLinkUiPolicy.hasNativeVolumePercentage(listOf("音量", "调节音量")))
        assertFalse(FreeClip2MiLinkUiPolicy.hasNativeVolumePercentage(emptyList()))
    }
}
