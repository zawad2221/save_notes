package com.example.commonui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.design_system.theme.CustomTheme

@Composable
fun SelectionToolbar(
    selectedCount: Int,
    isAllPinned: Boolean,
    onCloseClicked: () -> Unit,
    onPinClicked: () -> Unit,
    onDeleteClicked: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(horizontal = CustomTheme.spacing.spacing8dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onCloseClicked) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = CustomTheme.colors.PureBlackAlpha100
                    )
                }
                Text(
                    text = "$selectedCount selected",
                    style = CustomTheme.typography.subhead1,
                    color = CustomTheme.colors.PureBlackAlpha100,
                    modifier = Modifier.padding(start = CustomTheme.spacing.spacing8dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onPinClicked) {
                    Icon(
                        imageVector = if (isAllPinned) Icons.Default.PushPin else Icons.Outlined.PushPin,
                        contentDescription = "Pin",
                        tint = if (isAllPinned) CustomTheme.colors.Purple40 else CustomTheme.colors.PureBlackAlpha100
                    )
                }
                IconButton(onClick = onDeleteClicked) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = CustomTheme.colors.PureBlackAlpha100
                    )
                }
            }
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = CustomTheme.colors.PureBlackAlpha10
        )
    }
}
