package com.example.exercise2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.exercise2.Data.MhsUIState

@Composable
fun Sumpage(
    mhsUIState: MhsUIState,
    onBackClick: () -> Unit,
    modifier: Modifier
){
    val items = listOf(
        Pair (stringResource(id = R.string.nma), mhsUIState.nama),
        Pair (stringResource(id = R.string.nim), mhsUIState.nim),
        Pair (stringResource(id = R.string.konsent), mhsUIState.konsen),
        Pair (stringResource(id = R.string.jdul), mhsUIState.judul),
        Pair (stringResource(id = R.string.dp1), mhsUIState.dp1),
        Pair (stringResource(id = R.string.dp2), mhsUIState.dp2)

    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier =
            Modifier.fillMaxWidth()
        ) {
            items.forEach { item ->
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(item.first.uppercase())
                    Text(
                        text = item.second.toString(), fontWeight =
                        FontWeight.Bold
                    )
                }
                Divider(
                    thickness =
                    dimensionResource(R.dimen.divider_thick)
                )
            }
            Spacer(
                modifier =
                Modifier.height(dimensionResource(R.dimen.padding_small))
            )

        }
        Row(
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement =
                Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                OutlinedButton(
                    onClick = onBackClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(stringResource(R.string.cncl))
                }
            }
        }
    }
}