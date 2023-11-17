package com.example.exercise2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Datamhspage(
    onSubmitClick: (MutableList<String>) -> Unit,
    dosenPilihan: List<String>,
    modifier: Modifier

){
    var nama by rememberSaveable { mutableStateOf("") }
    var nim by rememberSaveable { mutableStateOf("") }
    var konsen by rememberSaveable { mutableStateOf("") }
    var judul by remember { mutableStateOf("") }
    var dosenDipilih1 by remember { mutableStateOf("") }
    var dosenDipilih2 by remember { mutableStateOf("") }

    Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Formulir Pengajuan Skripsi")
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))

        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            label = { Text(text = "Nama") })
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))

        OutlinedTextField(
            value = nim,
            onValueChange = {nim = it},
            label = { Text(text = "NIM") })
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))

        OutlinedTextField(
            value = konsen,
            onValueChange = {konsen = it},
            label = { Text(text = "Konsentrasi") })
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))

        OutlinedTextField(
            value = judul,
            onValueChange = {judul = it},
            label = { Text(text = "Judul Skripsi") })
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))

        Row {
            Text(text = "Dosen Pembimbing 1")
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                dosenPilihan.forEach{item ->
                    Row(modifier = Modifier.selectable(
                        selected = dosenDipilih1 == item,
                        onClick ={dosenDipilih1 = item}
                    ),
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        RadioButton(selected = dosenDipilih1 == item,
                            onClick = {dosenDipilih1 = item})
                    }
                }
            }
            Text(text = "Dosen Pembimbing 2")
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                dosenPilihan.forEach{item ->
                    Row(modifier = Modifier.selectable(
                        selected = dosenDipilih2 == item,
                        onClick ={dosenDipilih2 = item}
                    ),
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        RadioButton(selected = dosenDipilih2 == item,
                            onClick = {dosenDipilih2 = item})
                    }
                }
            }
        }
        Button(onClick = {val datamhs = mutableListOf(nama, nim, konsen, judul)
        onSubmitClick(datamhs)},
            modifier = Modifier.weight(1f)) {
            Text(stringResource(id = R.string.submit_button))
        }
    }
}