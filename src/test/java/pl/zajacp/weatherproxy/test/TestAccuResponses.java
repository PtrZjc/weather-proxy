package pl.zajacp.weatherproxy.test;

public class TestAccuResponses {
    public final static String ACCU_LOCATION_RESPONSE = """
             [
               {
                 "Version": 1,
                 "Key": "341395_PC",
                 "Type": "PostalCode",
                 "Rank": 500,
                 "LocalizedName": "Wroclaw",
                 "EnglishName": "Wroclaw",
                 "PrimaryPostalCode": "53-522",
                 "Region": {
                   "ID": "EUR",
                   "LocalizedName": "Europe",
                   "EnglishName": "Europe"
                 },
                 "Country": {
                   "ID": "PL",
                   "LocalizedName": "Poland",
                   "EnglishName": "Poland"
                 },
                 "AdministrativeArea": {
                   "ID": "02",
                   "LocalizedName": "Lower Silesia",
                   "EnglishName": "Lower Silesia",
                   "Level": 1,
                   "LocalizedType": "Voivodship",
                   "EnglishType": "Voivodship",
                   "CountryID": "PL"
                 },
                 "TimeZone": {
                   "Code": "CET",
                   "Name": "Europe/Warsaw",
                   "GmtOffset": 1.0,
                   "IsDaylightSaving": false,
                   "NextOffsetChange": "2023-03-26T01:00:00Z"
                 },
                 "GeoPosition": {
                   "Latitude": 51.1,
                   "Longitude": 17.033,
                   "Elevation": {
                     "Metric": {
                       "Value": 114.0,
                       "Unit": "m",
                       "UnitType": 5
                     },
                     "Imperial": {
                       "Value": 375.0,
                       "Unit": "ft",
                       "UnitType": 0
                     }
                   }
                 },
                 "IsAlias": false,
                 "SupplementalAdminAreas": [],
                 "DataSets": [
                   "AirQualityCurrentConditions",
                   "AirQualityForecasts",
                   "Alerts",
                   "DailyPollenForecast",
                   "ForecastConfidence",
                   "FutureRadar",
                   "MinuteCast",
                   "Radar"
                 ]
               }
             ]
            """;

    public final static String ACCU_FORECAST_RESPONSE = """
            {
              "Headline": {
                "EffectiveDate": "2022-12-23T01:00:00+01:00",
                "EffectiveEpochDate": 1671753600,
                "Severity": 3,
                "Text": "Expect showery weather late Thursday night through Friday evening",
                "Category": "rain",
                "EndDate": "2022-12-24T01:00:00+01:00",
                "EndEpochDate": 1671840000,
                "MobileLink": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?lang=en-us",
                "Link": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?lang=en-us"
              },
              "DailyForecasts": [
                {
                  "Date": "2022-12-20T07:00:00+01:00",
                  "EpochDate": 1671516000,
                  "Temperature": {
                    "Minimum": {
                      "Value": 30.0,
                      "Unit": "F",
                      "UnitType": 18
                    },
                    "Maximum": {
                      "Value": 42.0,
                      "Unit": "F",
                      "UnitType": 18
                    }
                  },
                  "Day": {
                    "Icon": 6,
                    "IconPhrase": "Mostly cloudy",
                    "HasPrecipitation": false
                  },
                  "Night": {
                    "Icon": 7,
                    "IconPhrase": "Cloudy",
                    "HasPrecipitation": false
                  },
                  "Sources": [
                    "AccuWeather"
                  ],
                  "MobileLink": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=1&lang=en-us",
                  "Link": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=1&lang=en-us"
                },
                {
                  "Date": "2022-12-21T07:00:00+01:00",
                  "EpochDate": 1671602400,
                  "Temperature": {
                    "Minimum": {
                      "Value": 34.0,
                      "Unit": "F",
                      "UnitType": 18
                    },
                    "Maximum": {
                      "Value": 41.0,
                      "Unit": "F",
                      "UnitType": 18
                    }
                  },
                  "Day": {
                    "Icon": 12,
                    "IconPhrase": "Showers",
                    "HasPrecipitation": true,
                    "PrecipitationType": "Rain",
                    "PrecipitationIntensity": "Light"
                  },
                  "Night": {
                    "Icon": 36,
                    "IconPhrase": "Intermittent clouds",
                    "HasPrecipitation": false
                  },
                  "Sources": [
                    "AccuWeather"
                  ],
                  "MobileLink": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=2&lang=en-us",
                  "Link": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=2&lang=en-us"
                },
                {
                  "Date": "2022-12-22T07:00:00+01:00",
                  "EpochDate": 1671688800,
                  "Temperature": {
                    "Minimum": {
                      "Value": 40.0,
                      "Unit": "F",
                      "UnitType": 18
                    },
                    "Maximum": {
                      "Value": 45.0,
                      "Unit": "F",
                      "UnitType": 18
                    }
                  },
                  "Day": {
                    "Icon": 12,
                    "IconPhrase": "Showers",
                    "HasPrecipitation": true,
                    "PrecipitationType": "Rain",
                    "PrecipitationIntensity": "Light"
                  },
                  "Night": {
                    "Icon": 12,
                    "IconPhrase": "Showers",
                    "HasPrecipitation": true,
                    "PrecipitationType": "Rain",
                    "PrecipitationIntensity": "Light"
                  },
                  "Sources": [
                    "AccuWeather"
                  ],
                  "MobileLink": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=3&lang=en-us",
                  "Link": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=3&lang=en-us"
                },
                {
                  "Date": "2022-12-23T07:00:00+01:00",
                  "EpochDate": 1671775200,
                  "Temperature": {
                    "Minimum": {
                      "Value": 44.0,
                      "Unit": "F",
                      "UnitType": 18
                    },
                    "Maximum": {
                      "Value": 50.0,
                      "Unit": "F",
                      "UnitType": 18
                    }
                  },
                  "Day": {
                    "Icon": 7,
                    "IconPhrase": "Cloudy",
                    "HasPrecipitation": true,
                    "PrecipitationType": "Rain",
                    "PrecipitationIntensity": "Light"
                  },
                  "Night": {
                    "Icon": 12,
                    "IconPhrase": "Showers",
                    "HasPrecipitation": true,
                    "PrecipitationType": "Rain",
                    "PrecipitationIntensity": "Moderate"
                  },
                  "Sources": [
                    "AccuWeather"
                  ],
                  "MobileLink": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=4&lang=en-us",
                  "Link": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=4&lang=en-us"
                },
                {
                  "Date": "2022-12-24T07:00:00+01:00",
                  "EpochDate": 1671861600,
                  "Temperature": {
                    "Minimum": {
                      "Value": 40.0,
                      "Unit": "F",
                      "UnitType": 18
                    },
                    "Maximum": {
                      "Value": 51.0,
                      "Unit": "F",
                      "UnitType": 18
                    }
                  },
                  "Day": {
                    "Icon": 12,
                    "IconPhrase": "Showers",
                    "HasPrecipitation": true,
                    "PrecipitationType": "Rain",
                    "PrecipitationIntensity": "Light"
                  },
                  "Night": {
                    "Icon": 36,
                    "IconPhrase": "Intermittent clouds",
                    "HasPrecipitation": true,
                    "PrecipitationType": "Rain",
                    "PrecipitationIntensity": "Light"
                  },
                  "Sources": [
                    "AccuWeather"
                  ],
                  "MobileLink": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=5&lang=en-us",
                  "Link": "http://www.accuweather.com/en/pl/wrocaw/273125/daily-weather-forecast/273125?day=5&lang=en-us"
                }
              ]
            }
            """;

    public final static String ACCU_UNAUTHORIZED_RESPONSE = """
            {
                "Code": "Unauthorized",
                "Message": "Api Authorization failed",
                "Reference": "/locations/v1/postalcodes/PL/search?apikey=WRONG&q=53-522"
            }""";

    public final static String ACCU_EMPTY_LOCATION_RESPONSE = "[]";
}