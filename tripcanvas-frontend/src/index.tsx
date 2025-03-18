export interface User {
  id: number;
  email: string;
  fullName: string;
  profilePicture?: string;
  createdAt: string;
  updatedAt: string;
}

export interface Itinerary {
  id: number;
  title: string;
  description?: string;
  startDate: string;
  endDate: string;
  userId: number;
  createdAt: string;
  updatedAt: string;
}

export interface Activity {
  id: number;
  title: string;
  description?: string;
  startTime: string;
  endTime: string;
  location?: string;
  latitude?: number;
  longitude?: number;
  itineraryId: number;
  createdAt: string;
  updatedAt: string;
}

export interface AuthState {
  isAuthenticated: boolean;
  user: User | null;
  loading: boolean;
  error: string | null;
}