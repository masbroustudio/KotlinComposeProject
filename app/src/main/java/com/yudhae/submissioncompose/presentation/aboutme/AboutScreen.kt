package com.yudhae.submissioncompose.presentation.aboutme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yudhae.submissioncompose.R


@Composable
fun AboutScreen(
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                TopAppBarContent()
                ProfileScreen()
            }

        }
    }
}

@Composable
fun ProfileScreen(

    modifier: Modifier = Modifier,
) {
    val settingListRepo = AboutComponents()
    val getAllData = settingListRepo.getAllData()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 60.dp, top = 10.dp),

                ) {
                Text(text = "About the App")
            }
        }
        itemsIndexed(items = getAllData) { index, settingListModel ->
            AboutListItem(aboutSettingListModel = settingListModel)
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.profile_photo),
            contentDescription = stringResource(R.string.about_photo_desc),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(R.string.about_name_desc),
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)

        )
        Text(
            text = stringResource(R.string.about_email_desc),
            style = MaterialTheme.typography.subtitle1,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
        )
    }


}

@Composable
fun AboutListItem(aboutSettingListModel: AboutSettingListModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = aboutSettingListModel.imageVector,
            contentDescription = stringResource(id = aboutSettingListModel.contentDescription),
            tint = Color.White,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            modifier = Modifier.wrapContentSize(),
            text = stringResource(id = aboutSettingListModel.text)
        )
    }
}

@Composable
fun TopAppBarContent() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.setting_top_app_bar),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp,
    )
}