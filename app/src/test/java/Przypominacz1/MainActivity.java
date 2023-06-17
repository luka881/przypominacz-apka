import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.przypominacz.R;

import java.sql.Time;
import java.text.BreakIterator;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText reminderText;
    private Button dateButton, timeButton, saveButton;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reminderText = findViewById(R.id.reminder_text);
        dateButton = findViewById(R.id.date_button);
        timeButton = findViewById(R.id.time_button);
        saveButton = findViewById(R.id.save_button);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                mYear = year;
                                mMonth = monthOfYear;
                                mDay = dayOfMonth;
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reminder = reminderText.getText().toString();

                if (!reminder.isEmpty()) {
                    String reminderDateTime = mYear + "/" + (mMonth + 1) + "/" + mDay + " " + mHour + ":" + mMinute;
                    String reminderMessage = "Reminder: " + reminder + "\nDate and Time: " + reminderDateTime;
                    Toast.makeText(MainActivity.this, reminderMessage, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Enter reminder text!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



public class MainActivity extends AppCompatActivity {
    private Button dateButton, timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateButton = findViewById(R.id.date_button);
        timeButton = findViewById(R.id.time_button);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get current date
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // Display DatePickerDialog
                View saveButton;
                DatePickerDialog datePickerDialog = new DatePickerDialog(Button saveButton = findViewById(R.id.save_button);
                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Wywołaj metodę obsługującą zapis przypomnienia
                        saveReminder();
                    }

                    private void saveReminder() {
                    }
                });MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // Perform necessary actions with the selected date
                                Toast.makeText(MainActivity.this, "Selected date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year, Toast.LENGTH_SHORT).show();
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get current time
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                // Display TimePickerDialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                // Perform necessary actions with the selected time
                                Toast.makeText(MainActivity.this, "Selected time: " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
                private void saveReminder() {
                    // Pobierz wprowadzone dane z pól tekstowych, daty i czasu
                    BreakIterator reminderContentEditText;
                    String content = reminderContentEditText.getText().toString();
                    Date selectedDate;
                    Date date = selectedDate; // Pobierz datę z wybranego DatePicker
                    Time selectedTime;
                    Time time = selectedTime; // Pobierz czas z wybranego TimePicker

                    // Stwórz instancję przypomnienia na podstawie pobranych danych
                    Reminder reminder = new Reminder(content, date, time);

                    // Wywołaj metodę zapisu przypomnienia do bazy danych lub innego źródła danych
                    // np. reminderRepository.save(reminder);

                    // Wyświetl komunikat potwierdzający zapis przypomnienia
                    Toast.makeText(this, "Reminder saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}