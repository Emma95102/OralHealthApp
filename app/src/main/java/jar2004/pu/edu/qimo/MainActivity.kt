package jar2004.pu.edu.qimo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OralHealthApp()
        }
    }
}

@Composable
fun OralHealthApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("main_menu") { MainMenuScreen(navController) }
        composable("tooth_structure") { ToothStructureScreen(navController) }
        composable("brushing_techniques") { BrushingTechniquesScreen(navController) }
        composable("game_section") { GameSectionScreen(navController) }
        composable("brushing_game") { BrushingGameScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("歡迎來到兒童牙齒健康App!", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate("main_menu") }) {
                Text("開始")
            }
        }
    }
}

@Composable
fun MainMenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("主菜單", fontSize = 24.sp, modifier = Modifier.padding(bottom = 20.dp))
        Button(onClick = { navController.navigate("tooth_structure") }) {
            Text("學習牙齒構造")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate("brushing_techniques") }) {
            Text("學習刷牙技巧")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate("game_section") }) {
            Text("遊戲區")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate("settings") }) {
            Text("設定")
        }
    }
}

@Composable
fun ToothStructureScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("牙齒構造學習", fontSize = 24.sp, modifier = Modifier.padding(bottom = 20.dp))
        Text("1. 切牙: 負責切割食物")
        Text("2. 犬齒: 用來撕裂食物")
        Text("3. 臼齒: 幫助磨碎食物")

        Image(
            painter = painterResource(id = R.drawable.teeth), // Placeholder image
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("返回")
        }
    }
}

@Composable
fun BrushingTechniquesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("刷牙技巧學習", fontSize = 24.sp, modifier = Modifier.padding(bottom = 20.dp))
        Spacer(modifier = Modifier.height(10.dp))

        Text("1. 上牙由上往下刷(外側)")
        Image(
            painter = painterResource(id = R.drawable.cm1), // Placeholder image
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text("2. 下牙由下往上刷(外側)")
        Image(
            painter = painterResource(id = R.drawable.cm2), // Placeholder image
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text("3. 上牙由上往下刷(內側)")
        Image(
            painter = painterResource(id = R.drawable.cm3), // Placeholder image
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text("4. 下牙由下往上刷(內側)")
        Image(
            painter = painterResource(id = R.drawable.cm4), // Placeholder image
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text("5. 咬合面來回刷")
        Image(
            painter = painterResource(id = R.drawable.cm5), // Placeholder image
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text("6. 輕刷舌苔表面")
        Image(
            painter = painterResource(id = R.drawable.cm6), // Placeholder image
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("返回")
        }
    }
}

@Composable
fun GameSectionScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("遊戲區", fontSize = 24.sp, modifier = Modifier.padding(bottom = 20.dp))
        Button(onClick = { navController.navigate("brushing_game") }) {
            Text("刷牙遊戲")
        }
        Image(
            painter = painterResource(id = R.drawable.game4),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.game2),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.game3),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.game1),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("返回")
        }
    }
}

@Composable
fun BrushingGameScreen(navController: NavController) {
    BrushingGame()
    Button(onClick = { navController.popBackStack() }, modifier = Modifier.padding(16.dp)) {
        Text("返回")
    }
}

@Composable
fun BrushingGame() {
    var dirtySpots by remember { mutableStateOf(listOf(Offset(100f, 200f), Offset(300f, 400f), Offset(500f, 600f))) }
    var brushPosition by remember { mutableStateOf(Offset(0f, 0f)) }
    var cleanedCount by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Text("刷牙遊戲：清除牙齒上的髒污！", modifier = Modifier.padding(16.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRect(color = Color.White, size = size)
                drawRect(color = Color.Gray, size = size / 1.5f, topLeft = Offset(50f, 150f))
            }

            dirtySpots.forEach { dirtySpot ->
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(color = Color.Black, radius = 30f, center = dirtySpot)
                }
            }

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            brushPosition += dragAmount
                            dirtySpots = dirtySpots.filterNot { spot ->
                                val distance = brushPosition - spot
                                distance.getDistance() < 50f
                            }
                            cleanedCount = 3 - dirtySpots.size
                            change.consume()
                        }
                    }
            ) {
                drawRect(
                    color = Color.Blue,
                    size = Size(60f, 20f),
                    topLeft = brushPosition
                )
            }
        }

        if (cleanedCount == 3) {
            Text("恭喜！你清除了所有髒污！", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("設定頁面: 自定義你的App體驗!", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("返回")
            }
        }
    }
}
