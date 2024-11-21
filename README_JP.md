# チャットフィルタープラグイン
Minecraftのプラグインで、禁止単語をチャットから削除します。禁止単語を使用したプレイヤーは警告を受け、一定回数以上の違反をすると自動的にBANされます。さらに、サーバー管理者はプレイヤーの違反履歴を管理できます。

# 機能
 - 禁止単語を含むチャットメッセージを削除。
 - 禁止単語を使用したプレイヤーに警告メッセージを表示。
 - 違反回数を記録し、設定した回数を超えると自動BAN。
 - 警告回数やメッセージはすべて設定可能。
 - 管理者はコマンドでプレイヤーの違反履歴を削除可能。
 - Minecraft 1.16以降のバージョンに対応。
# コマンド
## ``/clearhistory <player>``
 - 説明: 指定したプレイヤーの違反履歴を削除します。
 - 権限: chatfilter.clearhistory
 - 使用例: /clearhistory Steve
## ``/history <player>``
 - 説明: 指定したプレイヤーの違反履歴を確認します。
 - 権限: chatfilter.history
 - 使用例: /history Steve
# 設定
 - プラグインは config.yml を使用して設定を管理します。主な設定項目は以下の通りです。

```yaml
コードをコピーする
banned-words:
  - badword1
  - badword2
max-infractions: 5
messages:
  warning: "&c禁止単語を使用しました！BANまで残り {remaining} 回です。"
  admin-notify: "&eプレイヤー {player} が禁止単語を使用しました！累計違反回数: {infractions}"
  ban-reason: "禁止単語の多用によりBANされました。"
banned-words: 禁止単語のリスト。
max-infractions: BANまでの警告回数。
messages: 警告、通知、BAN理由のメッセージをカスタマイズ。
```

# インストール
 - プラグインのjarファイルをダウンロードします。
 - サーバーの plugins フォルダーにjarファイルを配置します。
 - サーバーを再起動して設定ファイルを生成します。
 - 必要に応じて config.yml を編集して設定をカスタマイズします。
 - /reload コマンドか再起動で設定を適用します。
# 権限
 - ``chatfilter.clearhistory``: プレイヤーの違反履歴を削除可能。
 - ``chatfilter.history``: プレイヤーの違反履歴を確認可能。
 - ``chatfilter.bypass``: チャットフィルタリングの影響を受けない。
# 対応環境
 - Minecraftバージョン: 1.16以降。
 - サーバーソフトウェア: Bukkit、Spigot、Paper。
