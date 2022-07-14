# cloudflare-sdk

## Usage

```
Usage: cloudflare [OPTIONS]

Options:
  --email <email address>
  --key <secret key>
  --zone <zone name>
  --dns <dns record name>
  --list_zones
  --list_dns
  --update
  -h, --help               Show this message and exit
```

**Update (or insert) DNS**
```
cloudflare --email <email> --key <key> --update --zone=example.domain --dns='music,videos,photos'
```
The example above updates `music.example.domain`, `videos.example.domain`, and `photos.example.domain`.
