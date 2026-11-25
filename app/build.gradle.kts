name: Build Venticus APK

on:
  push:
    branches: [ main, master ]
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout repository
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: 17

      - name: Set up Gradle
        uses: gradle/actions/setup-gradle@v4
        with:
          gradle-version: '8.11.1'

      - name: Build Debug APK
        run: gradle assembleDebug --no-daemon

      - name: Upload APK
        uses: actions/upload-artifact@v4
        with:
          name: venticus-fitness-debug
          path: app/build/outputs/apk/debug/app-debug.apkpluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "VenticusFitness"
include(":app")plugins {
    id("com.android.application") version "8.9.2" apply false
    id("org.jetbrains.kotlin.android") version "2.1.20" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.20" apply false
}org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
android.useAndroidX=true
kotlin.code.style=official
android.nonTransitiveRClass=trueplugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.venticus.fitness"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.venticus.fitness"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.activity:activity-compose:1.10.0")
    implementation(platform("androidx.compose:compose-bom:2025.05.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
}<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
    <uses-permission android:name="android.permission.SCHEDULE_EXACT_ALARM" />
    <uses-permission android:name="android.permission.VIBRATE" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.VenticusFitness">

        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:windowSoftInputMode="adjustResize">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <receiver
            android:name=".alarm.WorkoutAlarmReceiver"
            android:exported="false" />
    </application>
</manifest>
<resources>
    <string name="app_name">VENTICUS Fitness</string>
</resources>
<resources>
    <style name="Theme.VenticusFitness" parent="android:Theme.Material.NoActionBar">
        <item name="android:statusBarColor">#07090F</item>
        <item name="android:navigationBarColor">#0B0E17</item>
    </style>
</resources>
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@drawable/ic_launcher_background" />
    <foreground android:drawable="@drawable/ic_launcher_foreground" />
</adaptive-icon>
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@drawable/ic_launcher_background" />
    <foreground android:drawable="@drawable/ic_launcher_foreground" />
</adaptive-icon>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:aapt="http://schemas.android.com/aapt"
    android:width="108dp"
    android:height="108dp"
    android:viewportWidth="108"
    android:viewportHeight="108">
    <path android:pathData="M0,0h108v108h-108z">
        <aapt:attr name="android:fillColor">
            <gradient
                android:type="radial"
                android:centerX="54"
                android:centerY="44"
                android:gradientRadius="72"
                android:startColor="#1A1F2E"
                android:endColor="#05070B" />
        </aapt:attr>
    </path>
</vector>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:aapt="http://schemas.android.com/aapt"
    android:width="108dp"
    android:height="108dp"
    android:viewportWidth="108"
    android:viewportHeight="108">
    <!-- Outer Royal Shield -->
    <path
        android:pathData="M54,22 L81,32 L78,61 C76,72 66,80 54,84 C42,80 32,72 30,61 L27,32 Z"
        android:fillColor="#0B0F1A"
        android:strokeWidth="2.4"
        android:strokeColor="#D4AF37" />
    <!-- Crown -->
    <path
        android:pathData="M45,32 L47,26 L51,30 L54,24 L57,30 L61,26 L63,32 Z"
        android:fillColor="#F5D061" />
    <!-- Gold Left V Wing -->
    <path android:pathData="M36,37 L44,37 L54,65 L54,75 Z">
        <aapt:attr name="android:fillColor">
            <gradient
                android:startX="36" android:startY="37"
                android:endX="54" android:endY="75"
                android:startColor="#FFF3B0"
                android:endColor="#B8860B" />
        </aapt:attr>
    </path>
    <!-- Platinum Right V Wing -->
    <path android:pathData="M72,37 L64,37 L54,65 L54,75 Z">
        <aapt:attr name="android:fillColor">
            <gradient
                android:startX="72" android:startY="37"
                android:endX="54" android:endY="75"
                android:startColor="#FFFFFF"
                android:endColor="#94A3B8" />
        </aapt:attr>
    </path>
    <!-- Emerald Vitality Drop -->
    <path
        android:pathData="M54,41 C54,41 58,47 58,50 C58,52.5 56.2,54.5 54,54.5 C51.8,54.5 50,52.5 50,50 C50,47 54,41 54,41 Z"
        android:fillColor="#22C55E" />
</vector>
package com.venticus.fitness.model

data class ExerciseItem(
    val id: Long = 0,
    val name: String,
    val poseKey: String, // pushup, squat, plank, lunge, jacks, crunches, bridge, curl, press
    val sets: Int,
    val reps: Int,
    val restSeconds: Int,
    val targetMuscle: String,
    val explanation: String,
    val completedSets: Int = 0
)

data class TimetableEntry(
    val id: Long = 0,
    val hour: Int,
    val minute: Int,
    val title: String,
    val alarmEnabled: Boolean = true
) {
    fun formattedTime(): String {
        val amPm = if (hour < 12) "AM" else "PM"
        val h12 = when {
            hour == 0 -> 12
            hour > 12 -> hour - 12
            else -> hour
        }
        return String.format("%02d:%02d %s", h12, minute, amPm)
    }
}

data class WaterState(
    val targetGlasses: Int = 10,
    val consumedGlasses: Int = 0
) {
    val remaining: Int get() = (targetGlasses - consumedGlasses).coerceAtLeast(0)
    val progress: Float get() = if (targetGlasses > 0) (consumedGlasses.toFloat() / targetGlasses).coerceIn(0f, 1f) else 0f
}

data class ChatMessage(
    val isUser: Boolean,
    val text: String
)
package com.venticus.fitness.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.venticus.fitness.model.ExerciseItem
import com.venticus.fitness.model.TimetableEntry
import com.venticus.fitness.model.WaterState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class OfflineStorage(context: Context) : SQLiteOpenHelper(context, "venticus_db", null, 1) {

    private val prefs = context.getSharedPreferences("venticus_prefs", Context.MODE_PRIVATE)

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE exercises (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                poseKey TEXT NOT NULL,
                sets INTEGER NOT NULL,
                reps INTEGER NOT NULL,
                restSeconds INTEGER NOT NULL,
                targetMuscle TEXT NOT NULL,
                explanation TEXT NOT NULL,
                completedSets INTEGER NOT NULL DEFAULT 0
            )
            """.trimIndent()
        )
        db.execSQL(
            """
            CREATE TABLE timetable (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                hour INTEGER NOT NULL,
                minute INTEGER NOT NULL,
                title TEXT NOT NULL,
                alarmEnabled INTEGER NOT NULL DEFAULT 1
            )
            """.trimIndent()
        )
        seedDefaultExercises(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    private fun seedDefaultExercises(db: SQLiteDatabase) {
        val defaults = listOf(
            ExerciseItem(
                name = "Classic Push-Ups",
                poseKey = "pushup",
                sets = 3,
                reps = 12,
                restSeconds = 60,
                targetMuscle = "Chest, Shoulders & Triceps",
                explanation = "1. Place hands slightly wider than shoulder-width.\n2. Keep body in a straight plank line from head to heels.\n3. Inhale as you lower chest near the floor (elbows at 45°).\n4. Exhale and push forcefully back up."
            ),
            ExerciseItem(
                name = "Bodyweight Squats",
                poseKey = "squat",
                sets = 4,
                reps = 15,
                restSeconds = 60,
                targetMuscle = "Quads, Glutes & Core",
                explanation = "1. Stand with feet shoulder-width apart, toes slightly out.\n2. Push hips back and bend knees like sitting into a chair.\n3. Keep chest lifted and heels flat until thighs are parallel.\n4. Drive through heels to stand tall."
            ),
            ExerciseItem(
                name = "Forearm Plank (Seconds)",
                poseKey = "plank",
                sets = 3,
                reps = 45,
                restSeconds = 45,
                targetMuscle = "Deep Core & Lower Back",
                explanation = "1. Rest on forearms with elbows directly under shoulders.\n2. Squeeze glutes and brace abs so hips do not sag.\n3. Keep neck neutral looking at the floor.\n4. Breathe steadily for the target seconds (counted as reps)."
            ),
            ExerciseItem(
                name = "Alternating Lunges",
                poseKey = "lunge",
                sets = 3,
                reps = 12,
                restSeconds = 60,
                targetMuscle = "Legs, Glutes & Balance",
                explanation = "1. Step one foot forward and lower hips until both knees form 90°.\n2. Keep front knee aligned over ankle, torso upright.\n3. Push off the front heel to return and switch legs."
            ),
            ExerciseItem(
                name = "Glute Bridges",
                poseKey = "bridge",
                sets = 3,
                reps = 15,
                restSeconds = 45,
                targetMuscle = "Glutes & Hamstrings",
                explanation = "1. Lie on your back with knees bent and feet flat hip-width apart.\n2. Squeeze glutes and lift hips until shoulders-hips-knees form a straight line.\n3. Pause 1 second at top, lower slowly."
            ),
            ExerciseItem(
                name = "Jumping Jacks",
                poseKey = "jacks",
                sets = 3,
                reps = 30,
                restSeconds = 45,
                targetMuscle = "Full Body Cardio & Stamina",
                explanation = "1. Start standing tall with arms at sides.\n2. Jump feet out wide while swinging arms overhead.\n3. Land softly on the balls of your feet and jump back."
            )
        )
        defaults.forEach { ex ->
            val cv = ContentValues().apply {
                put("name", ex.name)
                put("poseKey", ex.poseKey)
                put("sets", ex.sets)
                put("reps", ex.reps)
                put("restSeconds", ex.restSeconds)
                put("targetMuscle", ex.targetMuscle)
                put("explanation", ex.explanation)
                put("completedSets", 0)
            }
            db.insert("exercises", null, cv)
        }
    }

    // ---- API Key & Model ----
    fun getApiKey(): String = prefs.getString("gemini_api_key", "") ?: ""
    fun saveApiKey(key: String) {
        prefs.edit().putString("gemini_api_key", key.trim()).apply()
    }

    fun getModelId(): String = prefs.getString("gemini_model_id", "gemini-3.5-flash-lite") ?: "gemini-3.5-flash-lite"
    fun saveModelId(model: String) {
        prefs.edit().putString("gemini_model_id", model.trim().ifEmpty { "gemini-3.5-flash-lite" }).apply()
    }

    // ---- Water Tracker (Auto-resets daily) ----
    private fun todayKey(): String = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())

    fun getWaterState(): WaterState {
        val target = prefs.getInt("water_target", 10)
        val savedDate = prefs.getString("water_date", "")
        val today = todayKey()
        val consumed = if (savedDate == today) prefs.getInt("water_consumed", 0) else 0
        if (savedDate != today) {
            prefs.edit().putString("water_date", today).putInt("water_consumed", 0).apply()
        }
        return WaterState(targetGlasses = target, consumedGlasses = consumed)
    }

    fun saveWaterState(target: Int, consumed: Int) {
        prefs.edit()
            .putString("water_date", todayKey())
            .putInt("water_target", target.coerceIn(1, 30))
            .putInt("water_consumed", consumed.coerceIn(0, 40))
            .apply()
    }

    // ---- Exercises (Offline + AI Saved) ----
    fun getExercises(): List<ExerciseItem> {
        val list = mutableListOf<ExerciseItem>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM exercises ORDER BY id ASC", null)
        cursor.use {
            while (it.moveToNext()) {
                list.add(
                    ExerciseItem(
                        id = it.getLong(it.getColumnIndexOrThrow("id")),
                        name = it.getString(it.getColumnIndexOrThrow("name")),
                        poseKey = it.getString(it.getColumnIndexOrThrow("poseKey")),
                        sets = it.getInt(it.getColumnIndexOrThrow("sets")),
                        reps = it.getInt(it.getColumnIndexOrThrow("reps")),
                        restSeconds = it.getInt(it.getColumnIndexOrThrow("restSeconds")),
                        targetMuscle = it.getString(it.getColumnIndexOrThrow("targetMuscle")),
                        explanation = it.getString(it.getColumnIndexOrThrow("explanation")),
                        completedSets = it.getInt(it.getColumnIndexOrThrow("completedSets"))
                    )
                )
            }
        }
        return list
    }

    fun replaceExercises(items: List<ExerciseItem>) {
        val db = writableDatabase
        db.beginTransaction()
        try {
            db.delete("exercises", null, null)
            items.forEach { ex ->
                val cv = ContentValues().apply {
                    put("name", ex.name)
                    put("poseKey", ex.poseKey)
                    put("sets", ex.sets)
                    put("reps", ex.reps)
                    put("restSeconds", ex.restSeconds)
                    put("targetMuscle", ex.targetMuscle)
                    put("explanation", ex.explanation)
                    put("completedSets", 0)
                }
                db.insert("exercises", null, cv)
            }
            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
        }
    }

    fun updateCompletedSets(id: Long, completedSets: Int) {
        val cv = ContentValues().apply { put("completedSets", completedSets) }
        writableDatabase.update("exercises", cv, "id = ?", arrayOf(id.toString()))
    }

    fun resetAllExerciseProgress() {
        val cv = ContentValues().apply { put("completedSets", 0) }
        writableDatabase.update("exercises", cv, null, null)
    }

    // ---- Pure-Veg Diet Plan (Offline Cached) ----
    fun getSavedDiet(): String = prefs.getString("saved_veg_diet", "") ?: ""
    fun saveDiet(dietText: String) {
        prefs.edit().putString("saved_veg_diet", dietText).apply()
    }

    // ---- Timetable ----
    fun getTimetable(): List<TimetableEntry> {
        val list = mutableListOf<TimetableEntry>()
        val cursor = readableDatabase.rawQuery("SELECT * FROM timetable ORDER BY hour ASC, minute ASC", null)
        cursor.use {
            while (it.moveToNext()) {
                list.add(
                    TimetableEntry(
                        id = it.getLong(it.getColumnIndexOrThrow("id")),
                        hour = it.getInt(it.getColumnIndexOrThrow("hour")),
                        minute = it.getInt(it.getColumnIndexOrThrow("minute")),
                        title = it.getString(it.getColumnIndexOrThrow("title")),
                        alarmEnabled = it.getInt(it.getColumnIndexOrThrow("alarmEnabled")) == 1
                    )
                )
            }
        }
        return list
    }

    fun addTimetableEntry(entry: TimetableEntry): Long {
        val cv = ContentValues().apply {
            put("hour", entry.hour)
            put("minute", entry.minute)
            put("title", entry.title)
            put("alarmEnabled", if (entry.alarmEnabled) 1 else 0)
        }
        return writableDatabase.insert("timetable", null, cv)
    }

    fun replaceTimetable(entries: List<TimetableEntry>): List<TimetableEntry> {
        val db = writableDatabase
        val saved = mutableListOf<TimetableEntry>()
        db.beginTransaction()
        try {
            db.delete("timetable", null, null)
            entries.forEach { e ->
                val cv = ContentValues().apply {
                    put("hour", e.hour)
                    put("minute", e.minute)
                    put("title", e.title)
                    put("alarmEnabled", if (e.alarmEnabled) 1 else 0)
                }
                val newId = db.insert("timetable", null, cv)
                saved.add(e.copy(id = newId))
            }
            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
        }
        return saved
    }

    fun toggleTimetableAlarm(id: Long, enabled: Boolean) {
        val cv = ContentValues().apply { put("alarmEnabled", if (enabled) 1 else 0) }
        writableDatabase.update("timetable", cv, "id = ?", arrayOf(id.toString()))
    }

    fun deleteTimetableEntry(id: Long) {
        writableDatabase.delete("timetable", "id = ?", arrayOf(id.toString()))
    }
}
package com.venticus.fitness.ai

import com.venticus.fitness.model.ExerciseItem
import com.venticus.fitness.model.TimetableEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

object GeminiClient {

    private suspend fun callGemini(apiKey: String, modelId: String, prompt: String): String =
        withContext(Dispatchers.IO) {
            if (apiKey.isBlank()) {
                throw IllegalStateException("Please add your Gemini API key using the Key icon at the top right.")
            }
            val endpoint =
                "https://generativelanguage.googleapis.com/v1beta/models/$modelId:generateContent?key=$apiKey"
            val conn = (URL(endpoint).openConnection() as HttpURLConnection).apply {
                requestMethod = "POST"
                setRequestProperty("Content-Type", "application/json")
                connectTimeout = 20000
                readTimeout = 30000
                doOutput = true
            }

            val body = JSONObject().apply {
                put("contents", JSONArray().apply {
                    put(JSONObject().apply {
                        put("parts", JSONArray().apply {
                            put(JSONObject().put("text", prompt))
                        })
                    })
                })
            }

            OutputStreamWriter(conn.outputStream, Charsets.UTF_8).use {
                it.write(body.toString())
            }

            val code = conn.responseCode
            val stream = if (code in 200..299) conn.inputStream else conn.errorStream
            val raw = BufferedReader(InputStreamReader(stream, Charsets.UTF_8)).use { it.readText() }
            conn.disconnect()

            if (code !in 200..299) {
                val msg = try {
                    JSONObject(raw).getJSONObject("error").getString("message")
                } catch (_: Exception) {
                    "HTTP $code error from Gemini"
                }
                throw IllegalStateException(msg)
            }

            val root = JSONObject(raw)
            val candidates = root.getJSONArray("candidates")
            val parts = candidates.getJSONObject(0).getJSONObject("content").getJSONArray("parts")
            parts.getJSONObject(0).getString("text")
        }

    private fun extractJsonArray(raw: String): JSONArray {
        val cleaned = raw
            .replace("```json", "", ignoreCase = true)
            .replace("```", "")
            .trim()
        val start = cleaned.indexOf('[')
        val end = cleaned.lastIndexOf(']')
        if (start == -1 || end == -1 || end <= start) {
            throw IllegalStateException("AI did not return a valid list. Try again.")
        }
        return JSONArray(cleaned.substring(start, end + 1))
    }

    suspend fun generateWorkoutPlan(
        apiKey: String,
        modelId: String,
        goal: String,
        level: String,
        equipment: String,
        minutes: Int,
        focus: String
    ): List<ExerciseItem> {
        val prompt = """
            You are an elite fitness coach. Create a safe, effective workout plan based on:
            - Goal: $goal
            - Fitness Level: $level
            - Equipment Available: $equipment
            - Daily Workout Time: $minutes minutes
            - Target Area / Notes: $focus

            Return ONLY a valid JSON array (no extra text, no markdown). Each object must have:
            - "name": string (exercise name)
            - "poseKey": string (choose closest from: "pushup", "squat", "plank", "lunge", "jacks", "crunches", "bridge", "curl", "press")
            - "sets": integer (e.g. 3 or 4)
            - "reps": integer (e.g. 12, or seconds if plank)
            - "restSeconds": integer (e.g. 45 or 60)
            - "targetMuscle": string (short muscle group name)
            - "explanation": string (clear numbered 1-2-3-4 step-by-step form & breathing guide)
        """.trimIndent()

        val raw = callGemini(apiKey, modelId, prompt)
        val arr = extractJsonArray(raw)
        val result = mutableListOf<ExerciseItem>()
        for (i in 0 until arr.length()) {
            val obj = arr.getJSONObject(i)
            result.add(
                ExerciseItem(
                    name = obj.optString("name", "Exercise ${i + 1}"),
                    poseKey = obj.optString("poseKey", "pushup"),
                    sets = obj.optInt("sets", 3).coerceIn(1, 10),
                    reps = obj.optInt("reps", 12).coerceIn(1, 120),
                    restSeconds = obj.optInt("restSeconds", 60).coerceIn(15, 180),
                    targetMuscle = obj.optString("targetMuscle", "Full Body"),
                    explanation = obj.optString("explanation", "Perform with slow controlled form.")
                )
            )
        }
        return result
    }

    suspend fun generatePureVegDiet(
        apiKey: String,
        modelId: String,
        workoutSummary: String,
        weightKg: String,
        goal: String,
        preference: String
    ): String {
        val prompt = """
            You are a sports nutritionist specializing in 100% PURE VEGETARIAN high-protein diets.
            Strict rule: NO meat, NO fish, NO eggs.
            Dietary style: $preference.
            User weight: ${weightKg}kg | Goal: $goal.
            Current Workout Plan:
            $workoutSummary

            Build a practical, protein-rich daily meal plan (Early Morning, Breakfast, Mid-Morning, Lunch, Pre-Workout, Post-Workout, Dinner) using affordable high-protein veg foods (paneer, soya chunks, moong/masoor dal, chana, rajma, sprouts, curd/Greek yogurt, peanuts, oats, milk/whey if lacto-veg).
            Include approximate protein grams for each meal and total daily protein + hydration tip. Keep formatting clean with bullet points.
        """.trimIndent()
        return callGemini(apiKey, modelId, prompt)
    }

    suspend fun generateTimetable(
        apiKey: String,
        modelId: String,
        wakeTime: String,
        sleepTime: String,
        workoutTime: String,
        busyHours: String
    ): List<TimetableEntry> {
        val prompt = """
            Create a daily fitness, hydration, and pure-veg meal timetable for a user with:
            - Wake up: $wakeTime
            - Sleep: $sleepTime
            - Preferred Workout Time: $workoutTime
            - Busy/Work/College Hours: $busyHours

            Return ONLY a valid JSON array (no markdown, no extra text) of 7 to 9 entries.
            Each object must have:
            - "hour": integer (0 to 23, 24-hour format)
            - "minute": integer (0 to 59)
            - "title": string (short task like "Morning Water + Stretching", "High-Protein Veg Breakfast", "Main Workout Session", "Post-Workout Protein Meal", "Evening Hydration Check")
        """.trimIndent()

        val raw = callGemini(apiKey, modelId, prompt)
        val arr = extractJsonArray(raw)
        val list = mutableListOf<TimetableEntry>()
        for (i in 0 until arr.length()) {
            val o = arr.getJSONObject(i)
            list.add(
                TimetableEntry(
                    hour = o.optInt("hour", 7).coerceIn(0, 23),
                    minute = o.optInt("minute", 0).coerceIn(0, 59),
                    title = o.optString("title", "Fitness Task"),
                    alarmEnabled = true
                )
            )
        }
        return list
    }

    suspend fun askCoach(
        apiKey: String,
        modelId: String,
        workoutSummary: String,
        dietSummary: String,
        question: String
    ): String {
        val prompt = """
            You are VENTICUS AI, a royal-grade personal fitness and 100% pure vegetarian diet coach.
            User's current workout: $workoutSummary
            User's saved diet summary: ${dietSummary.take(400)}

            User question: "$question"
            Give a clear, motivating, accurate, practical answer (no meat/egg suggestions).
        """.trimIndent()
        return callGemini(apiKey, modelId, prompt)
    }
}
package com.venticus.fitness.alarm

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.app.NotificationCompat
import com.venticus.fitness.MainActivity
import com.venticus.fitness.model.TimetableEntry
import java.util.Calendar

class WorkoutAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.getStringExtra("ALARM_TITLE") ?: "Time for your Venticus Fitness routine!"
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "venticus_workout_alarms"

        val channel = NotificationChannel(
            channelId,
            "Venticus Workout & Diet Alarms",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            enableVibration(true)
        }
        manager.createNotificationChannel(channel)

        val openIntent = Intent(context, MainActivity::class.java)
        val contentPending = PendingIntent.getActivity(
            context,
            0,
            openIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
            .setContentTitle("VENTICUS Fitness Reminder")
            .setContentText(title)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(contentPending)
            .build()

        manager.notify(System.currentTimeMillis().toInt(), notification)

        try {
            @Suppress("DEPRECATION")
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
            vibrator?.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
        } catch (_: Exception) {}
    }
}

object AlarmScheduler {
    fun schedule(context: Context, entry: TimetableEntry) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, WorkoutAlarmReceiver::class.java).apply {
            putExtra("ALARM_TITLE", "${entry.formattedTime()} • ${entry.title}")
        }
        val pending = PendingIntent.getBroadcast(
            context,
            entry.id.toInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        if (!entry.alarmEnabled) {
            alarmManager.cancel(pending)
            return
        }

        val cal = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, entry.hour)
            set(Calendar.MINUTE, entry.minute)
            set(Calendar.SECOND, 0)
            if (timeInMillis <= System.currentTimeMillis()) {
                add(Calendar.DAY_OF_YEAR, 1)
            }
        }

        val canExact = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            alarmManager.canScheduleExactAlarms()
        } else true

        if (canExact) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pending)
        } else {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pending)
        }
    }

    fun cancel(context: Context, id: Long) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, WorkoutAlarmReceiver::class.java)
        val pending = PendingIntent.getBroadcast(
            context,
            id.toInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        alarmManager.cancel(pending)
    }
}
package com.venticus.fitness.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseIllustration(poseKey: String, modifier: Modifier = Modifier) {
    val gold = Color(0xFFD4AF37)
    val platinum = Color(0xFFE2E8F0)
    val emerald = Color(0xFF22C55E)
    val floorColor = Color(0xFF334155)

    Box(
        modifier = modifier
            .background(Color(0xFF0A0D16), RoundedCornerShape(14.dp))
            .border(1.dp, Color(0xFF2A2F42), RoundedCornerShape(14.dp))
            .padding(8.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val floorY = h * 0.84f

            // Ground / Mat line
            drawLine(
                color = floorColor,
                start = Offset(w * 0.08f, floorY),
                end = Offset(w * 0.92f, floorY),
                strokeWidth = 4f,
                cap = StrokeCap.Round
            )

            when (poseKey.lowercase()) {
                "pushup" -> {
                    // Body plank angle
                    drawCircle(gold, radius = 9f, center = Offset(w * 0.74f, h * 0.44f))
                    drawLine(platinum, Offset(w * 0.70f, h * 0.50f), Offset(w * 0.22f, floorY - 4f), 9f, StrokeCap.Round)
                    // Arms
                    drawLine(gold, Offset(w * 0.67f, h * 0.52f), Offset(w * 0.67f, floorY), 7f, StrokeCap.Round)
                    // Movement arrow
                    drawLine(emerald, Offset(w * 0.55f, h * 0.28f), Offset(w * 0.55f, h * 0.46f), 4f, StrokeCap.Round,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f)))
                }
                "plank" -> {
                    drawCircle(gold, radius = 9f, center = Offset(w * 0.76f, h * 0.54f))
                    drawLine(platinum, Offset(w * 0.71f, h * 0.59f), Offset(w * 0.20f, floorY - 4f), 9f, StrokeCap.Round)
                    // Forearm L-shape
                    drawLine(gold, Offset(w * 0.68f, h * 0.60f), Offset(w * 0.68f, floorY - 4f), 7f, StrokeCap.Round)
                    drawLine(gold, Offset(w * 0.68f, floorY - 4f), Offset(w * 0.78f, floorY - 4f), 7f, StrokeCap.Round)
                    // Core highlight
                    drawCircle(emerald, radius = 10f, center = Offset(w * 0.48f, h * 0.68f), alpha = 0.55f)
                }
                "squat" -> {
                    // Squat posture
                    drawCircle(gold, radius = 9f, center = Offset(w * 0.56f, h * 0.26f))
                    drawLine(platinum, Offset(w * 0.54f, h * 0.34f), Offset(w * 0.40f, h * 0.56f), 9f, StrokeCap.Round) // torso
                    drawLine(gold, Offset(w * 0.40f, h * 0.56f), Offset(w * 0.58f, h * 0.62f), 8f, StrokeCap.Round) // thighs
                    drawLine(platinum, Offset(w * 0.58f, h * 0.62f), Offset(w * 0.50f, floorY), 8f, StrokeCap.Round) // shins
                    // Arms forward for balance
                    drawLine(emerald, Offset(w * 0.52f, h * 0.38f), Offset(w * 0.74f, h * 0.42f), 6f, StrokeCap.Round)
                }
                "lunge" -> {
                    drawCircle(gold, radius = 9f, center = Offset(w * 0.50f, h * 0.24f))
                    drawLine(platinum, Offset(w * 0.50f, h * 0.32f), Offset(w * 0.50f, h * 0.54f), 9f, StrokeCap.Round)
                    // Front leg 90 deg
                    drawLine(gold, Offset(w * 0.50f, h * 0.54f), Offset(w * 0.70f, h * 0.58f), 8f, StrokeCap.Round)
                    drawLine(gold, Offset(w * 0.70f, h * 0.58f), Offset(w * 0.70f, floorY), 8f, StrokeCap.Round)
                    // Back leg
                    drawLine(platinum, Offset(w * 0.50f, h * 0.54f), Offset(w * 0.32f, h * 0.70f), 8f, StrokeCap.Round)
                    drawLine(platinum, Offset(w * 0.32f, h * 0.70f), Offset(w * 0.24f, floorY), 8f, StrokeCap.Round)
                }
                "bridge" -> {
                    drawCircle(gold, radius = 8f, center = Offset(w * 0.22f, floorY - 10f))
                    drawLine(platinum, Offset(w * 0.28f, floorY - 6f), Offset(w * 0.58f, h * 0.52f), 9f, StrokeCap.Round)
                    drawLine(gold, Offset(w * 0.58f, h * 0.52f), Offset(w * 0.74f, floorY), 8f, StrokeCap.Round)
                    drawCircle(emerald, radius = 10f, center = Offset(w * 0.56f, h * 0.52f), alpha = 0.5f)
                }
                "jacks" -> {
                    drawCircle(gold, radius = 9f, center = Offset(w * 0.50f, h * 0.22f))
                    drawLine(platinum, Offset(w * 0.50f, h * 0.30f), Offset(w * 0.50f, h * 0.56f), 9f, StrokeCap.Round)
                    // Arms V up
                    drawLine(gold, Offset(w * 0.50f, h * 0.35f), Offset(w * 0.30f, h * 0.16f), 6f, StrokeCap.Round)
                    drawLine(gold, Offset(w * 0.50f, h * 0.35f), Offset(w * 0.70f, h * 0.16f), 6f, StrokeCap.Round)
                    // Legs wide
                    drawLine(emerald, Offset(w * 0.50f, h * 0.56f), Offset(w * 0.32f, floorY), 7f, StrokeCap.Round)
                    drawLine(emerald, Offset(w * 0.50f, h * 0.56f), Offset(w * 0.68f, floorY), 7f, StrokeCap.Round)
                }
                else -> {
                    // Dumbbell / Strength pose (curl, press, crunches, etc.)
                    drawCircle(gold, radius = 9f, center = Offset(w * 0.50f, h * 0.24f))
                    drawLine(platinum, Offset(w * 0.50f, h * 0.32f), Offset(w * 0.50f, h * 0.58f), 9f, StrokeCap.Round)
                    drawLine(platinum, Offset(w * 0.50f, h * 0.58f), Offset(w * 0.40f, floorY), 7f, StrokeCap.Round)
                    drawLine(platinum, Offset(w * 0.50f, h * 0.58f), Offset(w * 0.60f, floorY), 7f, StrokeCap.Round)
                    // Raised dumbbell arm
                    drawLine(gold, Offset(w * 0.50f, h * 0.36f), Offset(w * 0.68f, h * 0.32f), 6f, StrokeCap.Round)
                    drawLine(emerald, Offset(w * 0.68f, h * 0.32f), Offset(w * 0.70f, h * 0.18f), 6f, StrokeCap.Round)
                    drawCircle(gold, radius = 6f, center = Offset(w * 0.70f, h * 0.16f))
                }
            }
        }
    }
}
package com.venticus.fitness.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.venticus.fitness.model.ExerciseItem
import com.venticus.fitness.model.WaterState

private val RoyalGold = Color(0xFFD4AF37)
private val CardDark = Color(0xFF121622)
private val Emerald = Color(0xFF22C55E)
private val Aqua = Color(0xFF38BDF8)

@Composable
fun Page1WorkoutWater(
    waterState: WaterState,
    exercises: List<ExerciseItem>,
    isGeneratingWorkout: Boolean,
    statusError: String?,
    onUpdateWater: (target: Int, consumed: Int) -> Unit,
    onGenerateWorkoutWithGemini: (goal: String, level: String, equipment: String, minutes: Int, focus: String) -> Unit,
    onUpdateCompletedSets: (id: Long, newCompleted: Int) -> Unit,
    onResetWorkout: () -> Unit,
    onQuickRestTimer: (seconds: Int) -> Unit
) {
    var showTargetDialog by remember { mutableStateOf(false) }
    var showGeminiQuizDialog by remember { mutableStateOf(false) }

    val totalTargetSets = exercises.sumOf { it.sets }
    val totalDoneSets = exercises.sumOf { it.completedSets }
    val totalDoneReps = exercises.sumOf { it.completedSets * it.reps }
    val totalTargetReps = exercises.sumOf { it.sets * it.reps }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        // 1. WATER TRACKER & AUTO CALCULATOR
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardDark),
                border = BorderStroke(1.dp, Aqua.copy(alpha = 0.45f)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.WaterDrop, contentDescription = null, tint = Aqua)
                            Spacer(Modifier.width(8.dp))
                            Text(
                                "Hydration Tracker",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 17.sp
                            )
                        }
                        TextButton(onClick = { showTargetDialog = true }) {
                            Text("Target: ${waterState.targetGlasses}", color = RoyalGold, fontWeight = FontWeight.SemiBold)
                        }
                    }

                    LinearProgressIndicator(
                        progress = { waterState.progress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp),
                        color = Aqua,
                        trackColor = Color(0xFF1E293B)
                    )
                    Spacer(Modifier.height(8.dp))

                    val pct = (waterState.progress * 100).toInt()
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                "${waterState.consumedGlasses} / ${waterState.targetGlasses} Glasses ($pct%)",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                if (waterState.remaining == 0) "Daily target achieved!"
                                else "${waterState.remaining} glasses remaining (~${waterState.remaining * 250} ml)",
                                color = if (waterState.remaining == 0) Emerald else Color(0xFF94A3B8),
                                fontSize = 12.sp
                            )
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            FilledTonalIconButton(
                                onClick = {
                                    onUpdateWater(waterState.targetGlasses, (waterState.consumedGlasses - 1).coerceAtLeast(0))
                                }
                            ) {
                                Icon(Icons.Default.Remove, contentDescription = "Remove glass")
                            }
                            Button(
                                onClick = {
                                    onUpdateWater(waterState.targetGlasses, waterState.consumedGlasses + 1)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Aqua, contentColor = Color.Black)
                            ) {
                                Icon(Icons.Default.Add, contentDescription = null)
                                Spacer(Modifier.width(4.dp))
                                Text("1 Glass", fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
        }

        // 2. EXERCISE CALCULATOR & ONLINE/OFFLINE CONTROLS
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardDark),
                border = BorderStroke(1.dp, RoyalGold.copy(alpha = 0.55f)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("Workout Calculator", color = RoyalGold, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                            Text("Runs 100% Offline once generated", color = Emerald, fontSize = 12.sp)
                        }
                        IconButton(onClick = onResetWorkout) {
                            Icon(Icons.Default.Refresh, contentDescription = "Reset Progress", tint = Color(0xFF94A3B8))
                        }
                    }

                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        StatBadge("Sets Done", "$totalDoneSets / $totalTargetSets")
                        StatBadge("Reps Done", "$totalDoneReps / $totalTargetReps")
                        StatBadge("Exercises", "${exercises.size}")
                    }

                    Spacer(Modifier.height(12.dp))
                    Button(
                        onClick = { showGeminiQuizDialog = true },
                        enabled = !isGeneratingWorkout,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = RoyalGold, contentColor = Color.Black),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        if (isGeneratingWorkout) {
                            CircularProgressIndicator(modifier = Modifier.size(18.dp), color = Color.Black, strokeWidth = 2.dp)
                            Spacer(Modifier.width(8.dp))
                            Text("Gemini is crafting your sets & reps...", fontWeight = FontWeight.Bold)
                        } else {
                            Icon(Icons.Default.AutoAwesome, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text("Online: Ask Gemini to Make Perfect Plan", fontWeight = FontWeight.Bold)
                        }
                    }

                    if (!statusError.isNullOrBlank()) {
                        Spacer(Modifier.height(6.dp))
                        Text(statusError, color = Color(0xFFFCA5A5), fontSize = 12.sp)
                    }
                }
            }
        }

        // 3. EXERCISE CARDS WITH IMAGES & FULL EXPLANATION
        items(exercises, key = { it.id }) { ex ->
            ExerciseCard(
                exercise = ex,
                onIncrementSet = {
                    if (ex.completedSets < ex.sets) {
                        onUpdateCompletedSets(ex.id, ex.completedSets + 1)
                    }
                },
                onDecrementSet = {
                    if (ex.completedSets > 0) {
                        onUpdateCompletedSets(ex.id, ex.completedSets - 1)
                    }
                },
                onStartRest = { onQuickRestTimer(ex.restSeconds) }
            )
        }
    }

    if (showTargetDialog) {
        var targetInput by remember { mutableStateOf(waterState.targetGlasses.toString()) }
        AlertDialog(
            onDismissRequest = { showTargetDialog = false },
            containerColor = CardDark,
            title = { Text("Set Daily Water Target", color = RoyalGold) },
            text = {
                OutlinedTextField(
                    value = targetInput,
                    onValueChange = { targetInput = it.filter { ch -> ch.isDigit() } },
                    label = { Text("Glasses per day") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        val t = targetInput.toIntOrNull()?.coerceIn(1, 30) ?: 10
                        onUpdateWater(t, waterState.consumedGlasses)
                        showTargetDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = RoyalGold, contentColor = Color.Black)
                ) { Text("Save") }
            },
            dismissButton = {
                TextButton(onClick = { showTargetDialog = false }) { Text("Cancel") }
            }
        )
    }

    if (showGeminiQuizDialog) {
        GeminiWorkoutQuizDialog(
            onDismiss = { showGeminiQuizDialog = false },
            onSubmit = { goal, level, equip, mins, focus ->
                showGeminiQuizDialog = false
                onGenerateWorkoutWithGemini(goal, level, equip, mins, focus)
            }
        )
    }
}

@Composable
private fun StatBadge(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(label, color = Color(0xFF94A3B8), fontSize = 12.sp)
    }
}

@Composable
private fun ExerciseCard(
    exercise: ExerciseItem,
    onIncrementSet: () -> Unit,
    onDecrementSet: () -> Unit,
    onStartRest: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val isDone = exercise.completedSets >= exercise.sets

    Card(
        colors = CardDefaults.cardColors(containerColor = CardDark),
        border = BorderStroke(1.dp, if (isDone) Emerald else Color(0xFF262B3D)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ExerciseIllustration(
                    poseKey = exercise.poseKey,
                    modifier = Modifier.size(86.dp)
                )
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        exercise.name,
                        color = if (isDone) Emerald else Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(exercise.targetMuscle, color = RoyalGold, fontSize = 12.sp)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "${exercise.sets} Sets × ${exercise.reps} Reps  •  Rest ${exercise.restSeconds}s",
                        color = Color(0xFFCBD5E1),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        "Done: ${exercise.completedSets}/${exercise.sets} sets (${exercise.completedSets * exercise.reps} reps)",
                        color = if (isDone) Emerald else Color(0xFF94A3B8),
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    OutlinedButton(onClick = onDecrementSet, contentPadding = PaddingValues(horizontal = 10.dp)) {
                        Text("-1 Set")
                    }
                    Button(
                        onClick = onIncrementSet,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isDone) Emerald else RoyalGold,
                            contentColor = Color.Black
                        ),
                        contentPadding = PaddingValues(horizontal = 12.dp)
                    ) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(4.dp))
                        Text(if (isDone) "Done" else "+1 Set", fontWeight = FontWeight.Bold)
                    }
                }
                Row {
                    TextButton(onClick = onStartRest) {
                        Icon(Icons.Default.Timer, contentDescription = null, modifier = Modifier.size(16.dp), tint = Aqua)
                        Spacer(Modifier.width(4.dp))
                        Text("${exercise.restSeconds}s", color = Aqua)
                    }
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                            contentDescription = "Explanation",
                            tint = RoyalGold
                        )
                    }
                }
            }

            if (expanded) {
                HorizontalDivider(color = Color(0xFF262B3D), modifier = Modifier.padding(vertical = 8.dp))
                Text("Step-by-Step Form Guide:", color = RoyalGold, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                Spacer(Modifier.height(4.dp))
                Text(exercise.explanation, color = Color(0xFFE2E8F0), fontSize = 13.sp, lineHeight = 19.sp)
            }
        }
    }
}

@Composable
private fun GeminiWorkoutQuizDialog(
    onDismiss: () -> Unit,
    onSubmit: (goal: String, level: String, equipment: String, minutes: Int, focus: String) -> Unit
) {
    var goal by remember { mutableStateOf("Muscle Gain & Strength") }
    var level by remember { mutableStateOf("Beginner") }
    var equipment by remember { mutableStateOf("Home (Bodyweight)") }
    var minutes by remember { mutableStateOf("30") }
    var focus by remember { mutableStateOf("Full Body, no knee pain") }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = CardDark,
        title = { Text("Gemini Workout Questionnaire", color = RoyalGold, fontWeight = FontWeight.Bold) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Answer these quick questions so Gemini creates your exact sets & reps:", fontSize = 12.sp, color = Color(0xFF94A3B8))
                OutlinedTextField(value = goal, onValueChange = { goal = it }, label = { Text("1. Fitness Goal (Fat Loss / Muscle / Stamina)") }, singleLine = true)
                OutlinedTextField(value = level, onValueChange = { level = it }, label = { Text("2. Level (Beginner / Intermediate / Pro)") }, singleLine = true)
                OutlinedTextField(value = equipment, onValueChange = { equipment = it }, label = { Text("3. Equipment (Home / Dumbbells / Full Gym)") }, singleLine = true)
                OutlinedTextField(
                    value = minutes,
                    onValueChange = { minutes = it.filter { c -> c.isDigit() } },
                    label = { Text("4. Minutes per day") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )
                OutlinedTextField(value = focus, onValueChange = { focus = it }, label = { Text("5. Target Muscles / Any Injury Notes") }, singleLine = true)
            }
        },
        confirmButton = {
            Button(
                onClick = { onSubmit(goal, level, equipment, minutes.toIntOrNull() ?: 30, focus) },
                colors = ButtonDefaults.buttonColors(containerColor = RoyalGold, contentColor = Color.Black)
            ) { Text("Generate & Save Offline", fontWeight = FontWeight.Bold) }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancel") }
        }
    )
}
package com.venticus.fitness.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.venticus.fitness.model.ChatMessage
import com.venticus.fitness.model.TimetableEntry

private val RoyalGold = Color(0xFFD4AF37)
private val CardDark = Color(0xFF121622)
private val Emerald = Color(0xFF22C55E)
private val Aqua = Color(0xFF38BDF8)

@Composable
fun Page2DietCoach(
    timerSecondsLeft: Int,
    timerRunning: Boolean,
    onStartTimer: (Int) -> Unit,
    onTogglePauseTimer: () -> Unit,
    onResetTimer: () -> Unit,
    savedDiet: String,
    isGeneratingDiet: Boolean,
    onGenerateVegDiet: (weightKg: String, goal: String, style: String) -> Unit,
    timetable: List<TimetableEntry>,
    isGeneratingTimetable: Boolean,
    onAddManualTimetable: (hour: Int, minute: Int, title: String) -> Unit,
    onGenerateAiTimetable: (wake: String, sleep: String, workout: String, busy: String) -> Unit,
    onToggleAlarm: (TimetableEntry) -> Unit,
    onDeleteTimetable: (Long) -> Unit,
    chatMessages: List<ChatMessage>,
    isChatLoading: Boolean,
    onSendChat: (String) -> Unit
) {
    var showDietDialog by remember { mutableStateOf(false) }
    var showManualTimeDialog by remember { mutableStateOf(false) }
    var showAiTimeDialog by remember { mutableStateOf(false) }
    var chatInput by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        // 1. WORKOUT TIMER
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardDark),
                border = BorderStroke(1.dp, Aqua.copy(alpha = 0.5f)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Timer, contentDescription = null, tint = Aqua)
                            Spacer(Modifier.width(8.dp))
                            Text("Workout Rest Timer", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                        }
                        val min = timerSecondsLeft / 60
                        val sec = timerSecondsLeft % 60
                        Text(
                            String.format("%02d:%02d", min, sec),
                            color = if (timerSecondsLeft <= 5 && timerSecondsLeft > 0) Color(0xFFF87171) else RoyalGold,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 26.sp
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        listOf(30, 60, 90, 120).forEach { sec ->
                            OutlinedButton(
                                onClick = { onStartTimer(sec) },
                                modifier = Modifier.weight(1f),
                                contentPadding = PaddingValues(0.dp)
                            ) { Text("${sec}s", fontSize = 12.sp) }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(
                            onClick = onTogglePauseTimer,
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = Aqua, contentColor = Color.Black)
                        ) {
                            Icon(if (timerRunning) Icons.Default.Pause else Icons.Default.PlayArrow, contentDescription = null)
                            Spacer(Modifier.width(4.dp))
                            Text(if (timerRunning) "Pause" else "Start", fontWeight = FontWeight.Bold)
                        }
                        OutlinedButton(onClick = onResetTimer) {
                            Icon(Icons.Default.Refresh, contentDescription = null)
                            Spacer(Modifier.width(4.dp))
                            Text("Reset")
                        }
                    }
                }
            }
        }

        // 2. PURE-VEG PROTEIN DIET ASSISTANT (GEMINI)
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardDark),
                border = BorderStroke(1.dp, Emerald.copy(alpha = 0.55f)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.RestaurantMenu, contentDescription = null, tint = Emerald)
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text("Pure-Veg Protein Diet (Gemini)", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                            Text("Synced with your Page 1 workouts • Saved offline", color = Emerald, fontSize = 12.sp)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = { showDietDialog = true },
                        enabled = !isGeneratingDiet,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Emerald, contentColor = Color.Black)
                    ) {
                        if (isGeneratingDiet) {
                            CircularProgressIndicator(modifier = Modifier.size(18.dp), color = Color.Black, strokeWidth = 2.dp)
                            Spacer(Modifier.width(8.dp))
                            Text("Preparing Pure-Veg Plan...", fontWeight = FontWeight.Bold)
                        } else {
                            Icon(Icons.Default.AutoAwesome, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text("Generate High-Protein Pure-Veg Diet", fontWeight = FontWeight.Bold)
                        }
                    }
                    if (savedDiet.isNotBlank()) {
                        Spacer(Modifier.height(10.dp))
                        Text(savedDiet, color = Color(0xFFE2E8F0), fontSize = 13.sp, lineHeight = 19.sp)
                    }
                }
            }
        }

        // 3. TIMETABLE & ALARMS (MANUAL OR GEMINI)
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardDark),
                border = BorderStroke(1.dp, RoyalGold.copy(alpha = 0.5f)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Schedule, contentDescription = null, tint = RoyalGold)
                        Spacer(Modifier.width(8.dp))
                        Text("Workout Timetable & Alarms", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(
                            onClick = { showManualTimeDialog = true },
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp))
                            Text("Manual Add")
                        }
                        Button(
                            onClick = { showAiTimeDialog = true },
                            enabled = !isGeneratingTimetable,
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = RoyalGold, contentColor = Color.Black)
                        ) {
                            Icon(Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp))
                            Text(if (isGeneratingTimetable) "Building..." else "Gemini Plan", fontWeight = FontWeight.Bold)
                        }
                    }
                    if (timetable.isEmpty()) {
                        Spacer(Modifier.height(8.dp))
                        Text("No alarms scheduled yet. Add manually or generate with Gemini.", color = Color(0xFF94A3B8), fontSize = 12.sp)
                    }
                }
            }
        }

        items(timetable, key = { it.id }) { entry ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF161B29)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(entry.formattedTime(), color = RoyalGold, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text(entry.title, color = Color.White, fontSize = 14.sp)
                    }
                    Switch(
                        checked = entry.alarmEnabled,
                        onCheckedChange = { onToggleAlarm(entry) }
                    )
                    IconButton(onClick = { onDeleteTimetable(entry.id) }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color(0xFFF87171))
                    }
                }
            }
        }

        // 4. GEMINI FITNESS & DIET COACH CHAT
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardDark),
                border = BorderStroke(1.dp, Color(0xFF334155)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = RoyalGold)
                        Spacer(Modifier.width(8.dp))
                        Text("Ask Venticus AI Coach", color = RoyalGold, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    }
                    Spacer(Modifier.height(8.dp))

                    chatMessages.takeLast(8).forEach { msg ->
                        val bg = if (msg.isUser) Color(0xFF1E293B) else Color(0xFF0E241C)
                        Surface(
                            color = bg,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp)
                        ) {
                            Text(
                                (if (msg.isUser) "You: " else "Venticus AI: ") + msg.text,
                                modifier = Modifier.padding(10.dp),
                                color = Color.White,
                                fontSize = 13.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = chatInput,
                            onValueChange = { chatInput = it },
                            placeholder = { Text("Ask about protein, posture, fat loss...") },
                            modifier = Modifier.weight(1f),
                            maxLines = 3
                        )
                        Spacer(Modifier.width(8.dp))
                        IconButton(
                            onClick = {
                                if (chatInput.isNotBlank() && !isChatLoading) {
                                    onSendChat(chatInput.trim())
                                    chatInput = ""
                                }
                            }
                        ) {
                            if (isChatLoading) {
                                CircularProgressIndicator(modifier = Modifier.size(20.dp), color = RoyalGold, strokeWidth = 2.dp)
                            } else {
                                Icon(Icons.Default.Send, contentDescription = "Send", tint = RoyalGold)
                            }
                        }
                    }
                }
            }
        }
    }

    // ---- DIALOGS ----
    if (showDietDialog) {
        var weight by remember { mutableStateOf("65") }
        var goal by remember { mutableStateOf("Lean Muscle & High Protein") }
        var style by remember { mutableStateOf("Lacto-Vegetarian (Paneer, Curd, Milk, Dal, Soya)") }
        AlertDialog(
            onDismissRequest = { showDietDialog = false },
            containerColor = CardDark,
            title = { Text("Pure-Veg Diet Details", color = Emerald) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = weight,
                        onValueChange = { weight = it.filter { c -> c.isDigit() } },
                        label = { Text("Your Weight (kg)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true
                    )
                    OutlinedTextField(value = goal, onValueChange = { goal = it }, label = { Text("Fitness Goal") }, singleLine = true)
                    OutlinedTextField(value = style, onValueChange = { style = it }, label = { Text("Veg Type (Normal / Jain / Vegan)") })
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDietDialog = false
                        onGenerateVegDiet(weight.ifBlank { "65" }, goal, style)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Emerald, contentColor = Color.Black)
                ) { Text("Generate") }
            },
            dismissButton = { TextButton(onClick = { showDietDialog = false }) { Text("Cancel") } }
        )
    }

    if (showManualTimeDialog) {
        var hour by remember { mutableStateOf("7") }
        var minute by remember { mutableStateOf("0") }
        var title by remember { mutableStateOf("Morning Workout & Water") }
        AlertDialog(
            onDismissRequest = { showManualTimeDialog = false },
            containerColor = CardDark,
            title = { Text("Add Timetable Alarm", color = RoyalGold) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = hour,
                            onValueChange = { hour = it.filter { c -> c.isDigit() } },
                            label = { Text("Hour (0-23)") },
                            modifier = Modifier.weight(1f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = minute,
                            onValueChange = { minute = it.filter { c -> c.isDigit() } },
                            label = { Text("Min (0-59)") },
                            modifier = Modifier.weight(1f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true
                        )
                    }
                    OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Task Name") }, singleLine = true)
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val h = (hour.toIntOrNull() ?: 7).coerceIn(0, 23)
                        val m = (minute.toIntOrNull() ?: 0).coerceIn(0, 59)
                        onAddManualTimetable(h, m, title.ifBlank { "Workout Reminder" })
                        showManualTimeDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = RoyalGold, contentColor = Color.Black)
                ) { Text("Save & Set Alarm") }
            },
            dismissButton = { TextButton(onClick = { showManualTimeDialog = false }) { Text("Cancel") } }
        )
    }

    if (showAiTimeDialog) {
        var wake by remember { mutableStateOf("6:00 AM") }
        var sleep by remember { mutableStateOf("10:30 PM") }
        var workout by remember { mutableStateOf("7:00 AM") }
        var busy by remember { mutableStateOf("9:30 AM to 5:30 PM") }
        AlertDialog(
            onDismissRequest = { showAiTimeDialog = false },
            containerColor = CardDark,
            title = { Text("Gemini Timetable Setup", color = RoyalGold) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(value = wake, onValueChange = { wake = it }, label = { Text("Wake Up Time") }, singleLine = true)
                    OutlinedTextField(value = sleep, onValueChange = { sleep = it }, label = { Text("Sleep Time") }, singleLine = true)
                    OutlinedTextField(value = workout, onValueChange = { workout = it }, label = { Text("Preferred Workout Time") }, singleLine = true)
                    OutlinedTextField(value = busy, onValueChange = { busy = it }, label = { Text("College / Work Hours") }, singleLine = true)
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showAiTimeDialog = false
                        onGenerateAiTimetable(wake, sleep, workout, busy)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = RoyalGold, contentColor = Color.Black)
                ) { Text("Generate & Set Alarms") }
            },
            dismissButton = { TextButton(onClick = { showAiTimeDialog = false }) { Text("Cancel") } }
        )
    }
}
package com.venticus.fitness

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.venticus.fitness.ai.GeminiClient
import com.venticus.fitness.alarm.AlarmScheduler
import com.venticus.fitness.data.OfflineStorage
import com.venticus.fitness.model.ChatMessage
import com.venticus.fitness.model.TimetableEntry
import com.venticus.fitness.ui.Page1WorkoutWater
import com.venticus.fitness.ui.Page2DietCoach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private val ObsidianBg = Color(0xFF07090F)
private val NavBg = Color(0xFF0E121D)
private val RoyalGold = Color(0xFFD4AF37)

private val VenticusDarkScheme = darkColorScheme(
    primary = RoyalGold,
    onPrimary = Color.Black,
    background = ObsidianBg,
    surface = Color(0xFF121622),
    onBackground = Color.White,
    onSurface = Color.White
)

class MainActivity : ComponentActivity() {
    private val notificationPermLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                notificationPermLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }

        val storage = OfflineStorage(this)

        setContent {
            MaterialTheme(colorScheme = VenticusDarkScheme) {
                VenticusAppRoot(storage = storage)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VenticusAppRoot(storage: OfflineStorage) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var selectedTab by remember { mutableIntStateOf(0) }
    var showApiKeyDialog by remember { mutableStateOf(false) }

    // Page 1 states
    var waterState by remember { mutableStateOf(storage.getWaterState()) }
    var exercises by remember { mutableStateOf(storage.getExercises()) }
    var isGeneratingWorkout by remember { mutableStateOf(false) }
    var workoutError by remember { mutableStateOf<String?>(null) }

    // Page 2 states
    var timerSecondsLeft by remember { mutableIntStateOf(60) }
    var timerRunning by remember { mutableStateOf(false) }
    var savedDiet by remember { mutableStateOf(storage.getSavedDiet()) }
    var isGeneratingDiet by remember { mutableStateOf(false) }
    var timetable by remember { mutableStateOf(storage.getTimetable()) }
    var isGeneratingTimetable by remember { mutableStateOf(false) }
    var chatMessages by remember {
        mutableStateOf(
            listOf(
                ChatMessage(
                    isUser = false,
                    text = "Welcome to VENTICUS Fitness! Ask me anything about exercises, form, or pure-veg protein meals."
                )
            )
        )
    }
    var isChatLoading by remember { mutableStateOf(false) }

    // Rest Countdown Timer Loop
    LaunchedEffect(timerRunning, timerSecondsLeft) {
        if (timerRunning && timerSecondsLeft > 0) {
            delay(1000L)
            timerSecondsLeft -= 1
            if (timerSecondsLeft == 0) {
                timerRunning = false
                ringTimerAlert(context)
            }
        }
    }

    Scaffold(
        containerColor = ObsidianBg,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            "VENTICUS",
                            color = RoyalGold,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 3.sp,
                            fontSize = 19.sp
                        )
                        Text("ROYAL FITNESS & VEG AI", color = Color(0xFF94A3B8), fontSize = 10.sp, letterSpacing = 2.sp)
                    }
                },
                actions = {
                    IconButton(onClick = { showApiKeyDialog = true }) {
                        Icon(Icons.Default.Key, contentDescription = "Gemini API Key", tint = RoyalGold)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NavBg)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = NavBg) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.FitnessCenter, contentDescription = null) },
                    label = { Text("Workout & Water") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.RestaurantMenu, contentDescription = null) },
                    label = { Text("Veg Diet & Coach") }
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            if (selectedTab == 0) {
                Page1WorkoutWater(
                    waterState = waterState,
                    exercises = exercises,
                    isGeneratingWorkout = isGeneratingWorkout,
                    statusError = workoutError,
                    onUpdateWater = { target, consumed ->
                        storage.saveWaterState(target, consumed)
                        waterState = storage.getWaterState()
                    },
                    onGenerateWorkoutWithGemini = { goal, level, equip, mins, focus ->
                        scope.launch {
                            isGeneratingWorkout = true
                            workoutError = null
                            try {
                                val generated = GeminiClient.generateWorkoutPlan(
                                    apiKey = storage.getApiKey(),
                                    modelId = storage.getModelId(),
                                    goal = goal,
                                    level = level,
                                    equipment = equip,
                                    minutes = mins,
                                    focus = focus
                                )
                                if (generated.isNotEmpty()) {
                                    storage.replaceExercises(generated)
                                    exercises = storage.getExercises()
                                }
                            } catch (e: Exception) {
                                workoutError = e.message ?: "Offline or error calling Gemini"
                            } finally {
                                isGeneratingWorkout = false
                            }
                        }
                    },
                    onUpdateCompletedSets = { id, newCompleted ->
                        storage.updateCompletedSets(id, newCompleted)
                        exercises = storage.getExercises()
                    },
                    onResetWorkout = {
                        storage.resetAllExerciseProgress()
                        exercises = storage.getExercises()
                    },
                    onQuickRestTimer = { secs ->
                        timerSecondsLeft = secs
                        timerRunning = true
                        selectedTab = 1
                    }
                )
            } else {
                Page2DietCoach(
                    timerSecondsLeft = timerSecondsLeft,
                    timerRunning = timerRunning,
                    onStartTimer = { secs ->
                        timerSecondsLeft = secs
                        timerRunning = true
                    },
                    onTogglePauseTimer = {
                        if (timerSecondsLeft > 0) timerRunning = !timerRunning
                    },
                    onResetTimer = {
                        timerRunning = false
                        timerSecondsLeft = 60
                    },
                    savedDiet = savedDiet,
                    isGeneratingDiet = isGeneratingDiet,
                    onGenerateVegDiet = { weight, goal, style ->
                        scope.launch {
                            isGeneratingDiet = true
                            try {
                                val summary = exercises.joinToString("; ") { "${it.name} (${it.sets}x${it.reps})" }
                                val diet = GeminiClient.generatePureVegDiet(
                                    apiKey = storage.getApiKey(),
                                    modelId = storage.getModelId(),
                                    workoutSummary = summary,
                                    weightKg = weight,
                                    goal = goal,
                                    preference = style
                                )
                                storage.saveDiet(diet)
                                savedDiet = diet
                            } catch (e: Exception) {
                                savedDiet = "Error: ${e.message}\n\n(Previously saved diet will appear once generated online.)"
                            } finally {
                                isGeneratingDiet = false
                            }
                        }
                    },
                    timetable = timetable,
                    isGeneratingTimetable = isGeneratingTimetable,
                    onAddManualTimetable = { h, m, title ->
                        val id = storage.addTimetableEntry(TimetableEntry(hour = h, minute = m, title = title, alarmEnabled = true))
                        val entry = TimetableEntry(id = id, hour = h, minute = m, title = title, alarmEnabled = true)
                        AlarmScheduler.schedule(context, entry)
                        timetable = storage.getTimetable()
                    },
                    onGenerateAiTimetable = { wake, sleep, workout, busy ->
                        scope.launch {
                            isGeneratingTimetable = true
                            try {
                                timetable.forEach { AlarmScheduler.cancel(context, it.id) }
                                val entries = GeminiClient.generateTimetable(
                                    apiKey = storage.getApiKey(),
                                    modelId = storage.getModelId(),
                                    wakeTime = wake,
                                    sleepTime = sleep,
                                    workoutTime = workout,
                                    busyHours = busy
                                )
                                val saved = storage.replaceTimetable(entries)
                                saved.forEach { AlarmScheduler.schedule(context, it) }
                                timetable = storage.getTimetable()
                            } catch (e: Exception) {
                                chatMessages = chatMessages + ChatMessage(false, "Timetable error: ${e.message}")
                            } finally {
                                isGeneratingTimetable = false
                            }
                        }
                    },
                    onToggleAlarm = { entry ->
                        val updated = entry.copy(alarmEnabled = !entry.alarmEnabled)
                        storage.toggleTimetableAlarm(entry.id, updated.alarmEnabled)
                        AlarmScheduler.schedule(context, updated)
                        timetable = storage.getTimetable()
                    },
                    onDeleteTimetable = { id ->
                        AlarmScheduler.cancel(context, id)
                        storage.deleteTimetableEntry(id)
                        timetable = storage.getTimetable()
                    },
                    chatMessages = chatMessages,
                    isChatLoading = isChatLoading,
                    onSendChat = { msg ->
                        chatMessages = chatMessages + ChatMessage(true, msg)
                        scope.launch {
                            isChatLoading = true
                            try {
                                val summary = exercises.joinToString("; ") { "${it.name} (${it.sets}x${it.reps})" }
                                val reply = GeminiClient.askCoach(
                                    apiKey = storage.getApiKey(),
                                    modelId = storage.getModelId(),
                                    workoutSummary = summary,
                                    dietSummary = savedDiet,
                                    question = msg
                                )
                                chatMessages = chatMessages + ChatMessage(false, reply)
                            } catch (e: Exception) {
                                chatMessages = chatMessages + ChatMessage(false, "Offline or error: ${e.message}")
                            } finally {
                                isChatLoading = false
                            }
                        }
                    }
                )
            }
        }
    }

    if (showApiKeyDialog) {
        var keyText by remember { mutableStateOf(storage.getApiKey()) }
        var modelText by remember { mutableStateOf(storage.getModelId()) }
        AlertDialog(
            onDismissRequest = { showApiKeyDialog = false },
            containerColor = Color(0xFF121622),
            title = { Text("Gemini AI Settings", color = RoyalGold, fontWeight = FontWeight.Bold) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        "Paste your free Gemini API key from aistudio.google.com (stored privately on your phone only).",
                        fontSize = 12.sp,
                        color = Color(0xFF94A3B8)
                    )
                    OutlinedTextField(
                        value = keyText,
                        onValueChange = { keyText = it },
                        label = { Text("Gemini API Key") },
                        singleLine = true
                    )
                    OutlinedTextField(
                        value = modelText,
                        onValueChange = { modelText = it },
                        label = { Text("Model ID (e.g. gemini-3.5-flash-lite)") },
                        singleLine = true
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        storage.saveApiKey(keyText)
                        storage.saveModelId(modelText)
                        showApiKeyDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = RoyalGold, contentColor = Color.Black)
                ) { Text("Save", fontWeight = FontWeight.Bold) }
            },
            dismissButton = { TextButton(onClick = { showApiKeyDialog = false }) { Text("Cancel") } }
        )
    }
}

private fun ringTimerAlert(context: Context) {
    try {
        ToneGenerator(AudioManager.STREAM_ALARM, 100).startTone(ToneGenerator.TONE_PROP_BEEP2, 700)
        @Suppress("DEPRECATION")
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        vibrator?.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
    } catch (_: Exception) {}
}
