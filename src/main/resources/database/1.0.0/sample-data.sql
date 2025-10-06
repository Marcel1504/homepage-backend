-- PROFILE
INSERT INTO content (type, language, version_date, data) VALUES
('PROFILE', 'DE', '2000-01-01', '
{
  "firstName": "Vorname",
  "lastName": "Nachname",
  "birthdate": "2000-01-01",
  "birthplace": "Ort",
  "details": "Geboren im Krankenhaus"
}');
INSERT INTO content (type, language, version_date, data) VALUES
('PROFILE', 'EN', '2000-01-01', '
{
  "firstName": "First Name",
  "lastName": "Last Name",
  "birthdate": "2000-01-01",
  "birthplace": "Place",
  "details": "Born in a hospital"
}');


-- PROJECTS
INSERT INTO content (type, language, version_date, data) VALUES
('PROJECTS', 'DE', '2000-01-01', '
[
  {
    "title": "Projekt A",
    "description": "Projekt A Beschreibung",
    "externalLink": "http://link.external",
    "thumbnailMedia": "thumbnail-media"
  }
]');
INSERT INTO content (type, language, version_date, data) VALUES
('PROJECTS', 'EN', '2000-01-01', '
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
('JOBS', 'DE', '2000-01-01', '
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
('JOBS', 'EN', '2000-01-01', '
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


-- CERTIFICATIONS
INSERT INTO content (type, language, version_date, data) VALUES
('CERTIFICATIONS', 'DE', '2000-01-01', '
[
  {
    "title": "Zertifikat A",
    "description": "Zertifikat A Beschreibung",
    "dateFrom": "2000-01-01",
    "dateTo": null
  }
]');
INSERT INTO content (type, language, version_date, data) VALUES
('CERTIFICATIONS', 'EN', '2000-01-01', '
[
  {
    "title": "Certificate A",
    "description": "Certificate A Beschreibung",
    "dateFrom": "2000-01-01",
    "dateTo": null
  }
]');


-- EDUCATION
INSERT INTO content (type, language, version_date, data) VALUES
('EDUCATION', 'DE', '2000-01-01', '
[
  {
    "institute": "Schule XYZ",
    "degree": "Meister",
    "dateFrom": "1990-01-01",
    "dateTo": "2020-01-01"
  }
]');
INSERT INTO content (type, language, version_date, data) VALUES
('EDUCATION', 'EN', '2000-01-01', '
[
  {
    "institute": "School XYZ",
    "degree": "Master",
    "dateFrom": "1990-01-01",
    "dateTo": "2020-01-01"
  }
]');


-- SOCIAL LINKS
INSERT INTO content (type, language, version_date, data) VALUES
('SOCIAL_LINKS', 'DE', '2000-01-01', '
[
  {
    "type": "SOCIAL_MEDIA_XY",
    "link": "http://link.to"
  }
]');
INSERT INTO content (type, language, version_date, data) VALUES
('SOCIAL_LINKS', 'EN', '2000-01-01', '
[
  {
    "type": "SOCIAL_MEDIA_XY",
    "link": "http://link.to"
  }
]');


-- LEGAL IMPRINT
INSERT INTO content (type, language, version_date, data) VALUES
('LEGAL_IMPRINT', 'DE', '2000-01-01', '
{
  "html": "<h1>Impressum</h1><p>Beispieltext für Impressum</p>"
}');
INSERT INTO content (type, language, version_date, data) VALUES
('LEGAL_IMPRINT', 'EN', '2000-01-01', '
{
  "html": "<h1>Imprint</h1><p>Sample text for imprint</p>"
}');


-- PRIVACY POLICY
INSERT INTO content (type, language, version_date, data) VALUES
('LEGAL_PRIVACY_POLICY', 'DE', '2000-01-01', '
{
  "html": "<h1>Datenschutzerklärung</h1><p>Beispieltext für Datenschutzerklärung</p>"
}');
INSERT INTO content (type, language, version_date, data) VALUES
('LEGAL_PRIVACY_POLICY', 'EN', '2000-01-01', '
{
  "html": "<h1>Privacy Policy</h1><p>Sample text for privacy policy</p>"
}');
