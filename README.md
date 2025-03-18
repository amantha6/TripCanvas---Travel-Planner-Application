# TripCanvas - Travel Planner Application

TripCanvas is a full-stack travel planning application built with Kotlin backend and React frontend. The application allows users to create and manage travel itineraries, search for locations, and receive personalized travel recommendations.

<img src="https://github.com/user-attachments/assets/5912ccfb-5a04-4e04-a30a-7fbe98d6a0ea" alt="TripCanvas Dashboard" width="800"/>
![WhatsApp Image 2025-03-13 at 17 28 31_df6df706](https://github.com/user-attachments/assets/c2db898a-fedc-4f14-a373-ec7d5017af1f)

## Project Overview

TripCanvas provides travelers with a seamless platform to:
- Create and manage detailed travel itineraries
- Search for destinations and attractions
- Store user preferences for personalized experiences
- Receive AI-powered travel recommendations

## Sample Views

### Trip Dashboard
<img src="https://images.unsplash.com/photo-1469854523086-cc02fe5d8800?q=80&w=2000" alt="Trip Dashboard" width="600"/>

### Itinerary Planning
<img src="https://images.unsplash.com/photo-1504150558240-0b4fd8946624?q=80&w=2000" alt="Itinerary Planning" width="600"/>

## Tech Stack

### Backend
- **Framework**: Spring Boot 
- **Language**: Kotlin
- **Database**: PostgreSQL
- **Authentication**: JWT-based authentication
- **API**: RESTful API design

### Frontend
- **Framework**: React
- **State Management**: Redux/Context API
- **Styling**: Material UI
- **HTTP Client**: Axios

## Project Structure
![image](https://github.com/user-attachments/assets/204c5d3d-f34e-4fd4-aa03-6c1058df7e90)
## API Endpoints

### Authentication
- `POST /api/auth/signup` - Register a new user
- `POST /api/auth/signin` - Authenticate and get JWT token

### User Management
- `GET /api/users/profile` - Get current user profile
- `PUT /api/users/profile` - Update user profile

## Current Progress

### Phase 1: Backend Setup (Completed)
- ✅ Spring Boot project structure
- ✅ Database schema and entity models
- ✅ Repository layer
- ✅ Service layer implementation
- ✅ JWT-based authentication
- ✅ Basic user management APIs

### Phase 2: Frontend Development (In Progress)
- ✅ React project setup
- ✅ Component structure
- ⏳ User authentication UI
- ⏳ Trip dashboard
- ⏳ Itinerary management interface

### Phase 3: AI Recommendation System (Planned)
- ⏳ Design recommendation algorithm
- ⏳ Integration with external location data APIs
- ⏳ Personalization based on user preferences
![image](https://github.com/user-attachments/assets/9c582757-b66b-44ce-af96-2d12e4972bb9)

## Setup Instructions

### Prerequisites
- JDK 17+
- PostgreSQL
- Node.js and npm

### Backend Setup
1. Clone the repository
2. Configure database connection in `application.properties`
3. Run the backend:
   ```bash
   ./gradlew bootRun
