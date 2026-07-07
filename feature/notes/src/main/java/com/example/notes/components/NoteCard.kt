package com.example.notes.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.design_system.theme.CustomTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteCard(
    noteId: Int,
    title: String = "",
    content: String = "",
    isSelected: Boolean,
    onSelected: (Int) -> Unit,
    onCardClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onCardClick.invoke(noteId) },
                onLongClick = { onSelected.invoke(noteId) }
            ),
        colors = CardDefaults.cardColors(containerColor = CustomTheme.colors.PureBlackAlpha5),
        shape = RoundedCornerShape(CustomTheme.spacing.spacing8dp),
        border = BorderStroke(
            width = if (isSelected) {
                CustomTheme.spacing.spacing2dp
            } else {
                CustomTheme.spacing.spacing1dp
            },
            color = if (isSelected) {
                CustomTheme.colors.Purple40
            } else {
                CustomTheme.colors.PurpleGrey80
            }
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CustomTheme.spacing.spacing12dp)
        ) {
            Text(
                text = title,
                style = CustomTheme.typography.subhead2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = content,
                modifier = Modifier.padding(top = CustomTheme.spacing.spacing6dp),
                style = CustomTheme.typography.body3,
                maxLines = 8,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}