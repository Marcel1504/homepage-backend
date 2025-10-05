-- PERSONAL
INSERT INTO content (type, language, version_date, data) VALUES
('PERSONAL', 'de', '2000-01-01', '
{
  "firstName": "Vorname",
  "lastName": "Nachname",
  "birthdate": "2000-01-01",
  "birthplace": "Ort"
}');
INSERT INTO content (type, language, version_date, data) VALUES
('PERSONAL', 'en', '2000-01-01', '
{
  "firstName": "First Name",
  "lastName": "Last Name",
  "birthdate": "2000-01-01",
  "birthplace": "Place"
}');


-- PROJECTS
INSERT INTO content (type, language, version_date, data) VALUES
('PROJECTS', 'de', '2000-01-01', '
[
  {
    "title": "Projekt A",
    "description": "Projekt A Beschreibung",
    "externalLink": "http://link.external",
    "thumbnailMedia": "thumbnail-media"
  }
]');
INSERT INTO content (type, language, version_date, data) VALUES
('PROJECTS', 'en', '2000-01-01', '
[
  {
    "title": "Project A",
    "description": "Project A description",
    "externalLink": "http://link.external",
    "thumbnailMedia": "thumbnail-media"
  }
]');


-- JOBS
INSERT INTO content (type, language, version_date, data) VALUES
('JOBS', 'de', '2000-01-01', '
[
  {
    "company": "Firma",
    "dateFrom": "1990-01-01",
    "dateTo": null,
    "roles": [
      {
        "dateFrom": "1990-01-01",
        "dateTo": "1999-12-31",
        "role": "Junior Rolle"
      },
      {
        "dateFrom": "2000-01-01",
        "dateTo": null,
        "role": "Senior Rolle"
      }
    ],
    "tasks": [
      {
        "dateFrom": "1990-01-01",
        "dateTo": "1999-12-31",
        "task": "Zeug machen"
      }
    ]
  }
]');
INSERT INTO content (type, language, version_date, data) VALUES
('JOBS', 'en', '2000-01-01', '
[
  {
    "company": "Company",
    "dateFrom": "1990-01-01",
    "dateTo": null,
    "roles": [
      {
        "dateFrom": "1990-01-01",
        "dateTo": "1999-12-31",
        "role": "Junior Role"
      },
      {
        "dateFrom": "2000-01-01",
        "dateTo": null,
        "role": "Senior Role"
      }
    ],
    "tasks": [
      {
        "dateFrom": "1990-01-01",
        "dateTo": "1999-12-31",
        "task": "Doing stuff"
      }
    ]
  }
]');


-- LEGAL IMPRINT
INSERT INTO content (type, language, version_date, data) VALUES
('LEGAL_IMPRINT', 'de', '2000-01-01', '
{
  "html": "<h1>Impressum</h1><p>Beispieltext für Impressum</p>"
}');
INSERT INTO content (type, language, version_date, data) VALUES
('LEGAL_IMPRINT', 'en', '2000-01-01', '
{
  "html": "<h1>Imprint</h1><p>Sample text for imprint</p>"
}');


-- PRIVACY POLICY
INSERT INTO content (type, language, version_date, data) VALUES
('LEGAL_PRIVACY_POLICY', 'de', '2000-01-01', '
{
  "html": "<h1>Datenschutzerklärung</h1><p>Beispieltext für Datenschutzerklärung</p>"
}');
INSERT INTO content (type, language, version_date, data) VALUES
('LEGAL_PRIVACY_POLICY', 'en', '2000-01-01', '
{
  "html": "<h1>Privacy Policy</h1><p>Sample text for privacy policy</p>"
}');
