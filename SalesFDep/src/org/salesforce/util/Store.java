package org.salesforce.util;

public class Store {

	/*
	 * 00Bj00000029B59
	   Auth Response: {
"id": "https://login.salesforce.com/id/00Dj0000001tsUfEAI/005j000000BV6VfAAL",
"issued_at": "1433912236149",
"scope": "id full custom_permissions api visualforce openid web refresh_token chatter_api",
"instance_url": "https://na16.salesforce.com",
"token_type": "Bearer",
"refresh_token": "5Aep861E3ECfhV22napW11Xs3gSfLT7xvn5u6IzYq_Q64Qk8_L3ea3ercuWU6zMt3KT0tDmYW.vcg==",
"id_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjE5NCJ9.eyJleHAiOjE0MzM5MTIzNTYsInN1YiI6Imh0dHBzOi8vbG9naW4uc2FsZXNmb3JjZS5jb20vaWQvMDBEajAwMDAwMDF0c1VmRUFJLzAwNWowMDAwMDBCVjZWZkFBTCIsImF0X2hhc2giOiJnOVM2elctVnpJTTJCdTRQUDZiejNnIiwiYXVkIjoiM01WRzlmTXRDa1Y2ZUxoY2tpcGNHdHNkRXNZN3BnSHRQOUtTSUl1WWszdlg2U1JseElPWHY0Y0NWZzhwVnJfdUZlLjRScjR5QlVBVzB6d19jYlJMTCIsImlzcyI6Imh0dHBzOi8vbG9naW4uc2FsZXNmb3JjZS5jb20iLCJpYXQiOjE0MzM5MTIyMzZ9.Qc_UqPZBUtOp34upYsugxvAxNe_-p1sMIoNwNoDLFTngvLiE0zt0mk6ge70h5qtIJ_-P450eA_-dd8CPp-x8Nuw8yVtvfbteIVo4Y8E6ILKmdM3SeVNDVe-BRgn0qcPe9udaiZYtZYkvW3XtZI4hwdKLfibPd_12yLz3wVk298roev6B6n6a-HFcBH9kJHb3R9Rpsmt9JXeKcoXoqW7bIwGXS_dWSBbCGvC2PCGV5YxuY5D4kT8QfrF0dz5_wHNRHMg7GRBSYK9Fn4_79g3PkbGBhD9KpBLmlXPPiYadQY58bKZ0mTMzH9VSeb9ZMJYFlFb6poq7xEhBs4xv6uYZEFWsg3n2s7vpMa7C_cICGdI2xbkqTbsan3oZBen_OoT1XaTmApSdHvjd9dkewNMP-NI4NBcpH4jx2RoPqIkPpkn7Jo0kzYvMxb53lsh-UdRlvarTs0qnDMKh6bSfmwoqpBeCKWwa34ndcldhOMyavKjTyI4njsCbjUdcuTff2X9GQBrCb4ocPgRCnf7P7_eoteUXkOHiNVMyiMN86wy0x1tPWoGP-IaFkdRufpg_lEof1ue6zai-zvXZjFoZYac6LmEkcabJiAAd5xvWv9VwB-p2NP-3WZ7ZB-hy5iGklDNvw4Kbp1ELRXouFH5mPO8RMTpeWlcYasBA_nCdIXMPPMk",
"access_token": "00Dj0000001tsUf!AR8AQC0yQeq1wEh5R2tWElA13q_8Sn.n8EyyyQ2Q23hoQt8SaDuWsgAhVHOeQYQHgjy2XQ.diYL6Z.W.08QeewjRB4ZgGImg",
"signature": "PYL/XQ7w5HoWBkxWlSD+/+9bC6C96gbnYr41Y2mM6+0="
} 
	*/ 
	/*
	Query response: {
	  "addr_city": null,
	  "email_verified": true,
	  "locale": "en_US",
	  "addr_state": null,
	  "asserted_user": true,
	  "nick_name": "ikhan",
	  "id": "https://login.salesforce.com/id/00Dj0000001tsUfEAI/005j000000BV6VfAAL",
	  "first_name": "Imran",
	  "timezone": "America/Los_Angeles",
	  "username": "ikhan@infrascape.com",
	  "mobile_phone": null,
	  "user_id": "005j000000BV6VfAAL",
	  "addr_street": null,
	  "status": {
	    "created_date": null,
	    "body": null
	  },
	  "user_type": "STANDARD",
	  "urls": {
	    "sobjects": "https://na16.salesforce.com/services/data/v{version}/sobjects/",
	    "feeds": "https://na16.salesforce.com/services/data/v{version}/chatter/feeds",
	    "users": "https://na16.salesforce.com/services/data/v{version}/chatter/users",
	    "query": "https://na16.salesforce.com/services/data/v{version}/query/",
	    "enterprise": "https://na16.salesforce.com/services/Soap/c/{version}/00Dj0000001tsUf",
	    "recent": "https://na16.salesforce.com/services/data/v{version}/recent/",
	    "feed_items": "https://na16.salesforce.com/services/data/v{version}/chatter/feed-items",
	    "search": "https://na16.salesforce.com/services/data/v{version}/search/",
	    "partner": "https://na16.salesforce.com/services/Soap/u/{version}/00Dj0000001tsUf",
	    "rest": "https://na16.salesforce.com/services/data/v{version}/",
	    "groups": "https://na16.salesforce.com/services/data/v{version}/chatter/groups",
	    "metadata": "https://na16.salesforce.com/services/Soap/m/{version}/00Dj0000001tsUf",
	    "profile": "https://na16.salesforce.com/005j000000BV6VfAAL"
	  },
	  "mobile_phone_verified": false,
	  "is_app_installed": true,
	  "photos": {
	    "picture": "https://c.na16.content.force.com/profilephoto/005/F",
	    "thumbnail": "https://c.na16.content.force.com/profilephoto/005/T"
	  },
	  "display_name": "Imran Khan",
	  "last_modified_date": "2015-06-08T09:16:07.000+0000",
	  "email": "skrishna@infrascape.com",
	  "addr_country": null,
	  "organization_id": "00Dj0000001tsUfEAI",
	  "last_name": "Khan",
	  "utcOffset": -28800000,
	  "active": true,
	  "language": "en_US",
	  "addr_zip": null
	}, 
	*/
}
