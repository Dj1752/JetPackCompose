package com.pratice.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
public fun PreviewItem(){
    //BlogCategory(R.drawable.ic_launcher_foreground,"text1","Testing1")
    LazyColumn(content = {
      items(getCatergoryList()){item ->
          BlogCategory(img = item.image, title = item.title, subtitle =item.subtitle )
      }
    })
}

@Composable
fun BlogCategory(img:Int,title:String,subtitle:String){
    Card(modifier = Modifier.padding(8.dp)) {
        Row {
            Image(painter = painterResource(id = img),
                colorFilter = ColorFilter.tint(Color.Black),
                contentDescription ="",
                modifier = Modifier
                    .size(80.dp)
                    .weight(.2f)   )
            ItemDesc(title, subtitle,
                Modifier
                    .padding(0.dp, 20.dp, 0.dp, 0.dp)
                    .weight(.8f))
        }
    }

}

@Composable
private fun ItemDesc(title: String, subtitle: String,modifier: Modifier) {
    Column(modifier) {
        Text(text = title,
            fontSize = 18.sp,
            style = MaterialTheme.typography.headlineLarge)
        Text(text = subtitle,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Thin,
            fontSize = 14.sp)
    }
}

data class CategoryData(val image:Int,val title: String,val subtitle: String)

fun getCatergoryList(): MutableList<CategoryData> {
    val list = mutableListOf<CategoryData>()
    list.add(CategoryData(R.drawable.ic_launcher_background,"Text1","Subtitle1"))
    list.add(CategoryData(R.drawable.ic_launcher_foreground,"Text2","Subtitle2"))
    list.add(CategoryData(R.drawable.ic_launcher_background,"Text3","Subtitle3"))
    list.add(CategoryData(R.drawable.ic_launcher_foreground,"Text4","Subtitle4"))
    list.add(CategoryData(R.drawable.ic_launcher_background,"Text5","Subtitle5"))
    list.add(CategoryData(R.drawable.ic_launcher_foreground,"Text6","Subtitle6"))
    list.add(CategoryData(R.drawable.ic_launcher_background,"Text7","Subtitle7"))
    list.add(CategoryData(R.drawable.ic_launcher_foreground,"Text8","Subtitle8"))
    list.add(CategoryData(R.drawable.ic_launcher_background,"Text9","Subtitle9"))
    list.add(CategoryData(R.drawable.ic_launcher_foreground,"Text10","Subtitle10"))
    list.add(CategoryData(R.drawable.ic_launcher_background,"Text11","Subtitle11"))
    list.add(CategoryData(R.drawable.ic_launcher_foreground,"Text12","Subtitle12"))
    return list
}

