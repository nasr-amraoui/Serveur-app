package com.example.serveur.ui.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun RecipeScreen() {
    var searchQuery by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Section with Profile and Date
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Hello, John",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.DateRange, contentDescription = "Calendar")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Search Section
        Text(
            text = "Explore new recipes 🔍",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Cuisine Types
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CuisineTypeChip(
                cuisineType = CuisineType("Italian", "🇮🇹"),
                isSelected = true
            )
            CuisineTypeChip(
                cuisineType = CuisineType("French", "🇫🇷"),
                isSelected = false
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Cooking Methods Grid
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CookingMethodCard(
                    cookingMethod = CookingMethod("Grilling", ""),
                    backgroundColor = Color(0xFFFCE4EC)
                )
                CookingMethodCard(
                    cookingMethod = CookingMethod("Baking", ""),
                    backgroundColor = Color(0xFFE3F2FD)
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CookingMethodCard(
                    cookingMethod = CookingMethod("Roasting", ""),
                    backgroundColor = Color(0xFFFFF3E0)
                )
                CookingMethodCard(
                    cookingMethod = CookingMethod("Frying", ""),
                    backgroundColor = Color(0xFFE8F5E9)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation
        NavigationBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                selected = true,
                onClick = { /* TODO */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                selected = false,
                onClick = { /* TODO */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Notifications, contentDescription = "Notifications") },
                selected = false,
                onClick = { /* TODO */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                selected = false,
                onClick = { /* TODO */ }
            )
        }
    }
}

@Composable
fun CuisineTypeChip(
    cuisineType: CuisineType,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer
               else MaterialTheme.colorScheme.surface,
        tonalElevation = 2.dp
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = cuisineType.flag)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = cuisineType.name,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CookingMethodCard(
    cookingMethod: CookingMethod,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(16.dp),
        color = backgroundColor
    ) {
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            IconButton(
                onClick = { /* TODO */ },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (cookingMethod.isFavorite) Icons.Default.Favorite
                                else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite"
                )
            }
            
            Text(
                text = cookingMethod.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.BottomStart)
            )
        }
    }
}
