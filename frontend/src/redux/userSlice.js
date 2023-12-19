// userSlice.js

import { createSlice } from '@reduxjs/toolkit';

const userSlice = createSlice({
  name: 'user',
  initialState: {
    username: '', // Change to 'username'
    // Add other user-related fields if needed
  },
  reducers: {
    setUser: (state, action) => {
      state.username = action.payload.username;
      // Set other user-related fields if needed
    },
  },
});

export const { setUser } = userSlice.actions;
export const selectUserName = (state) => state.user.username; // Change to 'username'
export default userSlice.reducer;
