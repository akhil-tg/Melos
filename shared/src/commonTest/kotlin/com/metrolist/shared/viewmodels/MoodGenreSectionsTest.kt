package com.metrolist.shared.viewmodels

import com.metrolist.shared.model.HomeSection
import com.metrolist.shared.model.PlaylistItem
import com.metrolist.shared.model.PodcastItem
import com.metrolist.shared.model.SongItem
import kotlin.test.Test
import kotlin.test.assertEquals

class MoodGenreSectionsTest {
    @Test
    fun featuredPlaylistsComeFirstFollowedBySongsThenCommunityPlaylists() {
        val featured = HomeSection("Featured", listOf(playlist("PL1"), playlist("PL2", author = "YouTube Music")))
        val songs = HomeSection("Top songs", listOf(song("s1"), song("s2")))
        val community = HomeSection("Community", listOf(playlist("PL3", author = "Chill Hits")))
        val other = HomeSection("Podcasts", listOf(PodcastItem("MPSPshow", "Show", null)))

        val reordered =
            reorderMoodGenreSections(listOf(other, community, songs, featured))

        assertEquals(listOf(featured, songs, community, other), reordered)
    }

    @Test
    fun sectionsInsideTheSameGroupKeepTheirRelativeOrder() {
        val community1 = HomeSection("Community one", listOf(playlist("PL1", author = "Curation")))
        val songs1 = HomeSection("Songs one", listOf(song("s1")))
        val songs2 = HomeSection("Songs two", listOf(song("s2")))
        val community2 = HomeSection("Community two", listOf(playlist("PL2", author = "Mixes")))

        val reordered = reorderMoodGenreSections(listOf(community1, songs1, songs2, community2))

        assertEquals(listOf(songs1, songs2, community1, community2), reordered)
    }

    @Test
    fun playlistSectionsWithoutAuthorAreFeatured() {
        val playlists = HomeSection("Editorial", listOf(playlist("PL1"), playlist("PL2", author = null)))
        val songs = HomeSection("Songs", listOf(song("s1")))

        assertEquals(listOf(playlists, songs), reorderMoodGenreSections(listOf(songs, playlists)))
    }

    @Test
    fun mixedCommunityAndEditorialCarouselCountsAsCommunity() {
        val mixed = HomeSection("Mixed", listOf(playlist("PL1", author = "YouTube Music"), playlist("PL2", author = "Rap Caviar")))
        val songs = HomeSection("Songs", listOf(song("s1")))

        assertEquals(listOf(songs, mixed), reorderMoodGenreSections(listOf(mixed, songs)))
    }

    @Test
    fun emptySectionsStayAtTheEndWithoutBreakingStability() {
        val empty = HomeSection("Empty", emptyList())
        val featured = HomeSection("Featured", listOf(playlist("PL1")))
        val songs = HomeSection("Songs", listOf(song("s1")))

        assertEquals(listOf(featured, songs, empty), reorderMoodGenreSections(listOf(empty, songs, featured)))
    }

    private fun song(id: String) = SongItem(id, id, null, emptyList(), null)

    private fun playlist(
        id: String,
        author: String? = null,
    ) = PlaylistItem(id, id, null, author = author)
}
