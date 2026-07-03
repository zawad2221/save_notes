package com.example.design_system.spacing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core.ui.dimens.R

@Immutable
data class DefaultSpacing(
    val spacing0dp: Dp = 0.dp,
    val spacing1dp: Dp = 1.dp,
    val spacing2dp: Dp = 2.dp,
    val spacing4dp: Dp = 4.dp,
    val spacing6dp: Dp = 6.dp,
    val spacing8dp: Dp = 8.dp,
    val spacing10dp: Dp = 10.dp,
    val spacing12dp: Dp = 12.dp,
    val spacing14dp: Dp = 14.dp,
    val spacing16dp: Dp = 16.dp,
    val spacing18dp: Dp = 18.dp,
    val spacing20dp: Dp = 20.dp,
    val spacing22dp: Dp = 22.dp,
    val spacing24dp: Dp = 24.dp,
    val spacing26dp: Dp = 26.dp,
    val spacing28dp: Dp = 28.dp,
    val spacing30dp: Dp = 30.dp,
    val spacing32dp: Dp = 32.dp
)

@Composable
fun rememberDefaultSpacing() = DefaultSpacing(
    spacing0dp = dimensionResource(id = R.dimen.default_spacing_0dp),
    spacing1dp = dimensionResource(id = R.dimen.default_spacing_1dp),
    spacing2dp = dimensionResource(id = R.dimen.default_spacing_2dp),
    spacing4dp = dimensionResource(id = R.dimen.default_spacing_4dp),
    spacing6dp = dimensionResource(id = R.dimen.default_spacing_6dp),
    spacing8dp = dimensionResource(id = R.dimen.default_spacing_8dp),
    spacing10dp = dimensionResource(id = R.dimen.default_spacing_10dp),
    spacing12dp = dimensionResource(id = R.dimen.default_spacing_12dp),
    spacing14dp = dimensionResource(id = R.dimen.default_spacing_14dp),
    spacing16dp = dimensionResource(id = R.dimen.default_spacing_16dp),
    spacing18dp = dimensionResource(id = R.dimen.default_spacing_18dp),
    spacing20dp = dimensionResource(id = R.dimen.default_spacing_20dp),
    spacing22dp = dimensionResource(id = R.dimen.default_spacing_22dp),
    spacing24dp = dimensionResource(id = R.dimen.default_spacing_24dp),
    spacing26dp = dimensionResource(id = R.dimen.default_spacing_26dp),
    spacing28dp = dimensionResource(id = R.dimen.default_spacing_28dp),
    spacing30dp = dimensionResource(id = R.dimen.default_spacing_30dp),
    spacing32dp = dimensionResource(id = R.dimen.default_spacing_32dp)
)
