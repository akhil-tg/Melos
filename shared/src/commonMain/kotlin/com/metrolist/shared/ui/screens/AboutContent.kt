/**
 * Metrolist Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.metrolist.shared.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.metrolist.shared.generated.resources.Res
import com.metrolist.shared.generated.resources.about
import com.metrolist.shared.generated.resources.brand_instagram
import com.metrolist.shared.generated.resources.brand_telegram
import com.metrolist.shared.generated.resources.brand_website
import com.metrolist.shared.generated.resources.credits_android_designer
import com.metrolist.shared.generated.resources.credits_android_developer
import com.metrolist.shared.generated.resources.credits_android_lead
import com.metrolist.shared.generated.resources.credits_collaborators_section
import com.metrolist.shared.generated.resources.credits_creator
import com.metrolist.shared.generated.resources.credits_creator_section
import com.metrolist.shared.generated.resources.credits_desktop_developer
import com.metrolist.shared.generated.resources.credits_desktop_lead
import com.metrolist.shared.generated.resources.credits_lead_developer
import com.metrolist.shared.generated.resources.credits_leads_section
import com.metrolist.shared.generated.resources.credits_license_desc
import com.metrolist.shared.generated.resources.credits_license_name
import com.metrolist.shared.generated.resources.credits_lyrics_ui_services
import com.metrolist.shared.generated.resources.credits_macos_developer
import com.metrolist.shared.generated.resources.credits_multiplatform_developer
import com.metrolist.shared.generated.resources.credits_wearos_designer
import com.metrolist.shared.generated.resources.credits_windows_developer
import com.metrolist.shared.generated.resources.discord_rpc_title
import com.metrolist.shared.generated.resources.open_github_profile
import com.metrolist.shared.generated.resources.open_website
import com.metrolist.shared.generated.resources.sponsor_developer
import com.metrolist.shared.ui.components.ModalBottomSheet
import com.metrolist.shared.ui.components.PlayerMenuAction
import com.metrolist.shared.ui.components.PlayerMenuPrimaryActions
import com.metrolist.shared.ui.components.images.AsyncImage
import com.metrolist.shared.ui.icons.MetrolistIcons
import com.metrolist.shared.ui.icons.MetrolistIconsBrand
import org.jetbrains.compose.resources.stringResource as sharedStringResource

@Composable
fun rememberAboutScreenText(): AboutScreenText =
    AboutScreenText(
        title = sharedStringResource(Res.string.about),
        creatorSection = sharedStringResource(Res.string.credits_creator_section),
        leadsSection = sharedStringResource(Res.string.credits_leads_section),
        collaborators = sharedStringResource(Res.string.credits_collaborators_section),
        leadDeveloperRole = sharedStringResource(Res.string.credits_lead_developer),
        creatorRole = sharedStringResource(Res.string.credits_creator),
        androidLeadRole = sharedStringResource(Res.string.credits_android_lead),
        desktopLeadRole = sharedStringResource(Res.string.credits_desktop_lead),
        discordRichPresenceRole = sharedStringResource(Res.string.discord_rpc_title),
        androidDevelopmentRole = sharedStringResource(Res.string.credits_android_developer),
        desktopDevelopmentRole = sharedStringResource(Res.string.credits_desktop_developer),
        multiplatformDevelopmentRole = sharedStringResource(Res.string.credits_multiplatform_developer),
        macosDevelopmentRole = sharedStringResource(Res.string.credits_macos_developer),
        windowsDevelopmentRole = sharedStringResource(Res.string.credits_windows_developer),
        lyricsUiServicesRole = sharedStringResource(Res.string.credits_lyrics_ui_services),
        androidDesignerRole = sharedStringResource(Res.string.credits_android_designer),
        wearOsDesignerRole = sharedStringResource(Res.string.credits_wearos_designer),
        website = sharedStringResource(Res.string.brand_website),
        telegram = sharedStringResource(Res.string.brand_telegram),
        instagram = sharedStringResource(Res.string.brand_instagram),
        license = sharedStringResource(Res.string.credits_license_name),
        licenseDescription = sharedStringResource(Res.string.credits_license_desc),
    )

enum class AboutContributorRole {
    LEAD_DEVELOPER,
    CREATOR,
    ANDROID_LEAD,
    DESKTOP_LEAD,
    DISCORD_RICH_PRESENCE,
    ANDROID_DEVELOPMENT,
    DESKTOP_DEVELOPMENT,
    MULTIPLATFORM_DEVELOPMENT,
    MACOS_DEVELOPMENT,
    WINDOWS_DEVELOPMENT,
    LYRICS_UI_SERVICES,
    ANDROID_DESIGNER,
    WEAROS_DESIGNER,
}

enum class AboutAvatarShape {
    COOKIE_4_SIDED,
    COOKIE_6_SIDED,
    COOKIE_9_SIDED,
    BURST,
    PUFFY_DIAMOND,
    SUNNY,
    GEM,
}

data class AboutContributor(
    val name: String,
    val role: AboutContributorRole,
    val githubHandle: String? = null,
    val websiteUrl: String? = null,
    val sponsorUrl: String? = null,
    val avatarShape: AboutAvatarShape,
    val customAvatarUrl: String? = null,
    val favoriteSongVideoId: String? = null,
) {
    val avatarUrl: String =
        customAvatarUrl
            ?: githubHandle?.let { "https://github.com/$it.png" }
            ?: error("Contributor $name needs a GitHub handle or customAvatarUrl")
    val githubUrl: String? = githubHandle?.let { "https://github.com/$it" }
}

object AboutContributors {
    val lead: AboutContributor =
        AboutContributor(
            name = "Akhil TG",
            role = AboutContributorRole.LEAD_DEVELOPER,
            githubHandle = "akhil-tg",
            customAvatarUrl = "https://raw.githubusercontent.com/akhil-tg/Melos_web/main/Dev.png",
            avatarShape = AboutAvatarShape.COOKIE_9_SIDED,
            favoriteSongVideoId = "FdMG84qN_98",
        )

    val leads: List<AboutContributor> = emptyList()

    val collaborators: List<AboutContributor> = emptyList()

    val all: List<AboutContributor> = listOf(lead)
}

enum class AboutCommunityLinkKind {
    WEBSITE,
    TELEGRAM,
    INSTAGRAM,
    LICENSE,
}

data class AboutCommunityLink(
    val kind: AboutCommunityLinkKind,
    val url: String,
)

val aboutCommunityLinks: List<AboutCommunityLink> =
    listOf(
        AboutCommunityLink(AboutCommunityLinkKind.WEBSITE, "https://akhil-tg.github.io/Melos_web/"),
        AboutCommunityLink(AboutCommunityLinkKind.TELEGRAM, "https://t.me/monstervlc_bot"),
        AboutCommunityLink(AboutCommunityLinkKind.INSTAGRAM, "https://www.instagram.com/akhil.tg_"),
    )

val aboutLicenseLink: AboutCommunityLink =
    AboutCommunityLink(AboutCommunityLinkKind.LICENSE, "https://github.com/akhil-tg/Melos")

data class AboutScreenText(
    val title: String,
    val creatorSection: String,
    val leadsSection: String,
    val collaborators: String,
    val leadDeveloperRole: String,
    val creatorRole: String,
    val androidLeadRole: String,
    val desktopLeadRole: String,
    val discordRichPresenceRole: String,
    val androidDevelopmentRole: String,
    val desktopDevelopmentRole: String,
    val multiplatformDevelopmentRole: String,
    val macosDevelopmentRole: String,
    val windowsDevelopmentRole: String,
    val lyricsUiServicesRole: String,
    val androidDesignerRole: String,
    val wearOsDesignerRole: String,
    val website: String,
    val telegram: String,
    val instagram: String,
    val license: String,
    val licenseDescription: String,
) {
    fun roleLabel(role: AboutContributorRole): String =
        when (role) {
            AboutContributorRole.LEAD_DEVELOPER -> leadDeveloperRole
            AboutContributorRole.CREATOR -> creatorRole
            AboutContributorRole.ANDROID_LEAD -> androidLeadRole
            AboutContributorRole.DESKTOP_LEAD -> desktopLeadRole
            AboutContributorRole.DISCORD_RICH_PRESENCE -> discordRichPresenceRole
            AboutContributorRole.ANDROID_DEVELOPMENT -> androidDevelopmentRole
            AboutContributorRole.DESKTOP_DEVELOPMENT -> desktopDevelopmentRole
            AboutContributorRole.MULTIPLATFORM_DEVELOPMENT -> multiplatformDevelopmentRole
            AboutContributorRole.MACOS_DEVELOPMENT -> macosDevelopmentRole
            AboutContributorRole.WINDOWS_DEVELOPMENT -> windowsDevelopmentRole
            AboutContributorRole.LYRICS_UI_SERVICES -> lyricsUiServicesRole
            AboutContributorRole.ANDROID_DESIGNER -> androidDesignerRole
            AboutContributorRole.WEAROS_DESIGNER -> wearOsDesignerRole
        }

    fun communityLabel(kind: AboutCommunityLinkKind): String =
        when (kind) {
            AboutCommunityLinkKind.WEBSITE -> website
            AboutCommunityLinkKind.TELEGRAM -> telegram
            AboutCommunityLinkKind.INSTAGRAM -> instagram
            AboutCommunityLinkKind.LICENSE -> license
        }
}

@Composable
internal fun CommunitySection(
    text: AboutScreenText,
    onOpenLink: (AboutCommunityLink) -> Unit,
) {
    PlayerMenuPrimaryActions(
        actions =
            aboutCommunityLinks.map { link ->
                PlayerMenuAction(
                    icon =
                        when (link.kind) {
                            AboutCommunityLinkKind.WEBSITE -> MetrolistIcons.Outlined.Language
                            AboutCommunityLinkKind.TELEGRAM -> MetrolistIconsBrand.Telegram
                            AboutCommunityLinkKind.INSTAGRAM -> MetrolistIconsBrand.Instagram
                            AboutCommunityLinkKind.LICENSE -> MetrolistIcons.Outlined.Info
                        },
                    title = text.communityLabel(link.kind),
                    onClick = { onOpenLink(link) },
                )
            },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorInfoSheet(
    contributor: AboutContributor,
    colorScheme: ColorScheme,
    onDismiss: () -> Unit,
    onOpenUrl: (String) -> Unit,
) {
    val roleLabel =
        when (contributor.role) {
            AboutContributorRole.LEAD_DEVELOPER -> sharedStringResource(Res.string.credits_lead_developer)
            AboutContributorRole.CREATOR -> sharedStringResource(Res.string.credits_creator)
            AboutContributorRole.ANDROID_LEAD -> sharedStringResource(Res.string.credits_android_lead)
            AboutContributorRole.DESKTOP_LEAD -> sharedStringResource(Res.string.credits_desktop_lead)
            AboutContributorRole.DISCORD_RICH_PRESENCE -> sharedStringResource(Res.string.discord_rpc_title)
            AboutContributorRole.ANDROID_DEVELOPMENT -> sharedStringResource(Res.string.credits_android_developer)
            AboutContributorRole.DESKTOP_DEVELOPMENT -> sharedStringResource(Res.string.credits_desktop_developer)
            AboutContributorRole.MULTIPLATFORM_DEVELOPMENT -> sharedStringResource(Res.string.credits_multiplatform_developer)
            AboutContributorRole.MACOS_DEVELOPMENT -> sharedStringResource(Res.string.credits_macos_developer)
            AboutContributorRole.WINDOWS_DEVELOPMENT -> sharedStringResource(Res.string.credits_windows_developer)
            AboutContributorRole.LYRICS_UI_SERVICES -> sharedStringResource(Res.string.credits_lyrics_ui_services)
            AboutContributorRole.ANDROID_DESIGNER -> sharedStringResource(Res.string.credits_android_designer)
            AboutContributorRole.WEAROS_DESIGNER -> sharedStringResource(Res.string.credits_wearos_designer)
        }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = colorScheme.surfaceContainerLow,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainerLow),
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    val avatarShape = contributorShape(contributor)
                    AsyncImage(
                        url = contributor.avatarUrl,
                        modifier = Modifier.size(72.dp).clip(avatarShape),
                        contentDescription = contributor.name,
                        shape = avatarShape,
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = contributor.name,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onSurface,
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = roleLabel,
                            style = MaterialTheme.typography.bodyMedium,
                            color = colorScheme.onSurfaceVariant,
                        )
                    }
                }

                contributor.websiteUrl?.let { url ->
                    Surface(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .clickable { onOpenUrl(url) },
                        shape = MaterialTheme.shapes.medium,
                        color = colorScheme.tertiaryContainer,
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Icon(
                                imageVector = MetrolistIcons.Outlined.Language,
                                contentDescription = null,
                                tint = colorScheme.onTertiaryContainer,
                                modifier = Modifier.size(20.dp),
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = sharedStringResource(Res.string.open_website),
                                color = colorScheme.onTertiaryContainer,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                    }
                }

                contributor.githubUrl?.let { url ->
                    Surface(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .clickable { onOpenUrl(url) },
                        shape = MaterialTheme.shapes.medium,
                        color = colorScheme.primaryContainer,
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Icon(
                                imageVector = MetrolistIconsBrand.Github,
                                contentDescription = null,
                                tint = colorScheme.onPrimaryContainer,
                                modifier = Modifier.size(20.dp),
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = sharedStringResource(Res.string.open_github_profile),
                                color = colorScheme.onPrimaryContainer,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                    }
                }

                contributor.sponsorUrl?.let { url ->
                    Surface(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .clickable { onOpenUrl(url) },
                        shape = MaterialTheme.shapes.medium,
                        color = colorScheme.secondaryContainer,
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            if (url.contains("buymeacoffee.com", ignoreCase = true)) {
                                Icon(
                                    imageVector = MetrolistIconsBrand.BuyMeACoffee,
                                    contentDescription = null,
                                    tint = colorScheme.onSecondaryContainer,
                                    modifier = Modifier.size(20.dp),
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                            Text(
                                text = sharedStringResource(Res.string.sponsor_developer),
                                color = colorScheme.onSecondaryContainer,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                    }
                }
            }
        }
    }
}
