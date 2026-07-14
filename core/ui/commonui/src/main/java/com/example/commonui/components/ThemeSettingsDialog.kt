package com.example.commonui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.design_system.theme.CustomTheme
import com.example.model.ThemeConfig

@Composable
fun ThemeSettingsDialog(
    onDismiss: () -> Unit,
    currentThemeConfig: ThemeConfig,
    onThemeConfigChange: (ThemeConfig) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Theme Settings",
                style = CustomTheme.typography.titleHeader
            )
        },
        text = {
            Column {
                ThemeOption(
                    text = "System Default",
                    selected = currentThemeConfig == ThemeConfig.SYSTEM,
                    onClick = { onThemeConfigChange(ThemeConfig.SYSTEM) }
                )
                ThemeOption(
                    text = "Light",
                    selected = currentThemeConfig == ThemeConfig.LIGHT,
                    onClick = { onThemeConfigChange(ThemeConfig.LIGHT) }
                )
                ThemeOption(
                    text = "Dark",
                    selected = currentThemeConfig == ThemeConfig.DARK,
                    onClick = { onThemeConfigChange(ThemeConfig.DARK) }
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close", style = CustomTheme.typography.subhead1)
            }
        }
    )
}

@Composable
fun ThemeOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = CustomTheme.spacing.spacing12dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = null
        )
        Text(
            text = text,
            style = CustomTheme.typography.body1,
            modifier = Modifier.padding(start = CustomTheme.spacing.spacing16dp)
        )
    }
}