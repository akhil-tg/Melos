/**
 * Metrolist Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.metrolist.android.update

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.metrolist.shared.generated.resources.Res
import com.metrolist.shared.generated.resources.forced_update_message
import com.metrolist.shared.generated.resources.forced_update_title
import com.metrolist.shared.generated.resources.updates_action
import com.metrolist.shared.ui.icons.MetrolistIcons
import org.jetbrains.compose.resources.stringResource

/**
 * Full-screen blocking dialog shown when the latest release forces a minimum
 * version. Blocks back navigation and offers no way to skip.
 */
@Composable
fun ForceUpdateGate(
    release: GitHubRelease,
    onUpdate: () -> Unit,
) {
    Dialog(
        onDismissRequest = {},
        properties =
            DialogProperties(
                usePlatformDefaultWidth = false,
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
            ),
    ) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp, vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Icon(
                    imageVector = MetrolistIcons.Outlined.Update,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(64.dp),
                )
                Spacer(Modifier.height(24.dp))
                Text(
                    text = stringResource(Res.string.forced_update_title),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = stringResource(Res.string.forced_update_message, release.version),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                )
                Spacer(Modifier.height(32.dp))
                when (AppUpdateManager.state.value) {
                    is AppUpdateState.Downloading,
                    is AppUpdateState.Downloaded,
                    -> {
                        CircularProgressIndicator()
                    }

                    else -> {
                        Button(onClick = onUpdate, shapes = ButtonDefaults.shapes()) {
                            Text(stringResource(Res.string.updates_action))
                        }
                    }
                }
            }
        }
    }
}
