package com.metrolist.shared.viewmodels

import com.metrolist.shared.model.HomeSection
import com.metrolist.shared.model.PlaylistItem
import com.metrolist.shared.model.SongItem

// Moods & genres browse pages mix editorial carousels, song lists and community playlists in a
// fixed InnerTube order; surface the predictable groups first instead.
private const val FEATURED_PLAYLISTS_GROUP = 0
private const val COMMUNITY_PLAYLISTS_GROUP = 1
private const val SONGS_GROUP = 2
private const val OTHER_GROUP = 3

// The "YouTube Music" editorial author name is a brand, so it stays untranslated across locales.
private fun PlaylistItem.isEditorialAuthor(): Boolean = author.isNullOrBlank() || author == "YouTube Music"

private fun HomeSection.isPlaylistCarousel(): Boolean = items.isNotEmpty() && items.all { it is PlaylistItem }

internal fun moodGenreSectionGroup(section: HomeSection): Int =
    when {
        section.items.isEmpty() -> {
            OTHER_GROUP
        }

        section.items.all { it is SongItem } -> {
            SONGS_GROUP
        }

        section.isPlaylistCarousel() -> {
            if (section.items.none { (it as PlaylistItem).isEditorialAuthor() }) {
                COMMUNITY_PLAYLISTS_GROUP
            } else {
                FEATURED_PLAYLISTS_GROUP
            }
        }

        else -> {
            OTHER_GROUP
        }
    }

/**
 * Reorders moods & genres sections: featured (editorial) playlists, community playlists, songs,
 * then everything else keeping its relative order. Kotlin sorts are stable, so sections within
 * the same group keep their original order.
 */
fun reorderMoodGenreSections(sections: List<HomeSection>): List<HomeSection> = sections.sortedBy(::moodGenreSectionGroup)
