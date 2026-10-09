package com.example.tugaspertemuan4

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun ukuranTeks(@DimenRes id: Int): TextUnit =
    with(LocalDensity.current) { dimensionResource(id).toSp() }

@Composable
fun CardMahasiswa(
    @DrawableRes logo: Int,
    @StringRes nama: Int,
    @StringRes alamat: Int,
    @ColorRes warnaCard: Int,
    @ColorRes warnaAlamat: Int,
    @StringRes telepon: Int? = null,
    @ColorRes warnaTelepon: Int = R.color.cyan,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(R.dimen.card_corner)))
            .background(colorResource(warnaCard))
            .padding(dimensionResource(R.dimen.card_padding)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(logo),
            contentDescription = stringResource(R.string.desc_logo),
            modifier = Modifier.size(dimensionResource(R.dimen.logo_size))
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = dimensionResource(R.dimen.spacing_medium))
        ) {
            Text(
                text = stringResource(nama),
                color = colorResource(R.color.white),
                fontSize = ukuranTeks(R.dimen.text_name),
                fontWeight = FontWeight.Bold
            )
            if (telepon != null) {
                Text(
                    text = stringResource(telepon),
                    color = colorResource(warnaTelepon),
                    fontSize = ukuranTeks(R.dimen.text_detail)
                )
            }
            Text(
                text = stringResource(alamat),
                color = colorResource(warnaAlamat),
                fontSize = ukuranTeks(R.dimen.text_detail)
            )
        }

