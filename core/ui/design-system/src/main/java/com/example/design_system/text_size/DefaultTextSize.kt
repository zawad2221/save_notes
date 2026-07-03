package com.example.design_system.text_size

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.core.ui.dimens.R

@Immutable
data class DefaultTextSize(
    val size8sp: TextUnit = 8.sp,
    val size10sp: TextUnit = 10.sp,
    val size12sp: TextUnit = 12.sp,
    val size14sp: TextUnit = 14.sp,
    val size16sp: TextUnit = 16.sp,
    val size18sp: TextUnit = 18.sp,
    val size20sp: TextUnit = 20.sp,
    val size22sp: TextUnit = 22.sp,
    val size24sp: TextUnit = 24.sp,
    val size26sp: TextUnit = 26.sp,
    val size28sp: TextUnit = 28.sp,
    val size30sp: TextUnit = 30.sp,
    val size32sp: TextUnit = 32.sp
)

@Composable
fun rememberDefaultTextSize(): DefaultTextSize {
    val density = LocalDensity.current
    return with(density) {
        DefaultTextSize(
            size8sp = dimensionResource(id = R.dimen.default_text_size_8sp).toSp(),
            size10sp = dimensionResource(id = R.dimen.default_text_size_10sp).toSp(),
            size12sp = dimensionResource(id = R.dimen.default_text_size_12sp).toSp(),
            size14sp = dimensionResource(id = R.dimen.default_text_size_14sp).toSp(),
            size16sp = dimensionResource(id = R.dimen.default_text_size_16sp).toSp(),
            size18sp = dimensionResource(id = R.dimen.default_text_size_18sp).toSp(),
            size20sp = dimensionResource(id = R.dimen.default_text_size_20sp).toSp(),
            size22sp = dimensionResource(id = R.dimen.default_text_size_22sp).toSp(),
            size24sp = dimensionResource(id = R.dimen.default_text_size_24sp).toSp(),
            size26sp = dimensionResource(id = R.dimen.default_text_size_26sp).toSp(),
            size28sp = dimensionResource(id = R.dimen.default_text_size_28sp).toSp(),
            size30sp = dimensionResource(id = R.dimen.default_text_size_30sp).toSp(),
            size32sp = dimensionResource(id = R.dimen.default_text_size_32sp).toSp()
        )
    }
}
